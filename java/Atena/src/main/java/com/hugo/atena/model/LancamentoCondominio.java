/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hugo.atena.model;

import com.hugo.atena.controler.MedicaoGasControler;
import com.hugo.atena.controler.enums.TamanhoApartamento;
import com.hugo.atena.controler.enums.TipoDespesa;
import com.hugo.atena.utils.HNumber;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */
@Entity
@Table(name = "lancamento_condominio")
public class LancamentoCondominio implements Serializable {

    @Id
    @SequenceGenerator(name = "lct_id", sequenceName = "seq_lancamento_despesas_id", allocationSize = 1)
    @GeneratedValue(generator = "lct_id", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne()
    @JoinColumn(name = "competencia_id", referencedColumnName = "id", nullable = false)
    private Competencia competencia;

    @ManyToOne()
    @JoinColumn(name = "apartamento_id", referencedColumnName = "id", nullable = false)
    private Apartamento apartamento;

    @ManyToOne()
    @JoinColumn(name = "medicaogas_id", referencedColumnName = "id", nullable = false)
    private MedicaoGas gas;

    @Column(name = "lct_valor_condominio", precision = 2)
    private Double valorCondominio;

    @Column(name = "lct_valor_fundo_reserva", precision = 2)
    private Double valorFundoReserva;

    @Column(name = "lct_valor_total", precision = 2)
    private Double valorTotal;

    //lancto - Nome do atributo
    @OneToMany(mappedBy = "lancto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LancamentoCondominioDespesa> despesas = new ArrayList<>();

    public LancamentoCondominio() {

    }

    private void validaRequisitosMinimosCalculo() throws Exception {

        if (getApartamento() == null) {
            throw new Exception("É obrigatório informar o apartamento.");
        }

        if (getCompetencia() == null) {
            throw new Exception("É obrigatório informar a competencia.");
        }

        if (getGas() == null) {
            
            setGas(MedicaoGasControler.get(getCompetencia()));
        
            if (getGas() == null) {
                throw new Exception("É obrigatório informar o valor de lançamento do gás.");
            }
        }

    }

    private void calculaCondominio() throws Exception {
        setValorCondominio(getApartamento().getTipoApartamento().getVlrCondominio());
    }

    private void calculaFundoReserva() throws Exception {
        setValorFundoReserva(getApartamento().getTipoApartamento().getVlrFundoReserva());
    }

    /**
     * Responsável por todo o cálculo das variáveis
     *
     * @param dcs
     * @throws Exception
     */
    public void calculaValores(List<DespesaCompartilhada> dcs) throws Exception {

        validaRequisitosMinimosCalculo();
        calculaCondominio();
        calculaFundoReserva();

        for (DespesaCompartilhada dc : dcs) {
            addDespesa(dc);
        }

        HNumber valor = new HNumber();

        //Soma valor condomínio
        valor = HNumber.sum(valor, getValorCondominio());

        //Soma fundoReserva 
        valor = HNumber.sum(valor, getValorFundoReserva());

        //Soma despesas
        for (LancamentoCondominioDespesa ld : getDespesas()) {
            
            valor = HNumber.sum(valor, ld.getValorCorrespondente());

        }

        setValorTotal(valor.doubleValue());

    }

    private void addDespesa(DespesaCompartilhada dc) throws Exception {

        if (this.getApartamento() == null) {
            throw new Exception("Não é possível adicionar uma despesa sem especificar um apartamento");
        }

        //Somente add se for uma desesa com investimento ou sem investimos (hoje não existe outros tipo, mas no futuro sim)
        if (TipoDespesa.COM_INVESTIMENTO == dc.getTipoDespesaa()
                || TipoDespesa.SEM_INVESTIMENTO == dc.getTipoDespesaa()) {

            if (this.getApartamento().isSindico()
                    && TipoDespesa.SEM_INVESTIMENTO == dc.getTipoDespesaa()) {
                //Sindico não participa de despesas sem investimento
                return;
            }

            HNumber valorParticipa = dc.getTipoDespesaa().valorParticipacao(TamanhoApartamento.GRANDE, dc.getValor());

            LancamentoCondominioDespesa ld = new LancamentoCondominioDespesa();
            ld.setCompartilhada(dc);
            ld.setLancto(this);
            ld.setValorCorrespondente(valorParticipa.rounds().doubleValue());

            this.getDespesas().add(ld);
        }

    }

    public void removerDespesa(int index) {
        this.getDespesas().remove(index);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the competencia
     */
    public Competencia getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     * @return the apartamento
     */
    public Apartamento getApartamento() {
        return apartamento;
    }

    /**
     * @param apartamento the apartamento to set
     */
    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    /**
     * @return the gas
     */
    public MedicaoGas getGas() {
        return gas;
    }

    /**
     * @param gas the gas to set
     */
    public void setGas(MedicaoGas gas) {
        this.gas = gas;
    }

    /**
     * @return the despesas
     */
    public List<LancamentoCondominioDespesa> getDespesas() {
        return despesas;
    }

    /**
     * Deixar utilizar sempre pelo ADD
     *
     * @param despesas the despesas to set
     */
    public void setDespesas(List<LancamentoCondominioDespesa> despesas) {
        this.despesas = despesas;
    }

    /**
     * @return the valorCondominio
     */
    public Double getValorCondominio() {
        return valorCondominio;
    }

    /**
     * @param valorCondominio the valorCondominio to set
     */
    public void setValorCondominio(Double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LancamentoCondominio other = (LancamentoCondominio) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    /**
     * @return the valorFundoReserva
     */
    public Double getValorFundoReserva() {
        return valorFundoReserva;
    }

    /**
     * @param valorFundoReserva the valorFundoReserva to set
     */
    public void setValorFundoReserva(Double valorFundoReserva) {
        this.valorFundoReserva = valorFundoReserva;
    }

}
