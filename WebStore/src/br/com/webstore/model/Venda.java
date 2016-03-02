/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Venda")
public class Venda {

	@Id
	@GeneratedValue
	@Column(name="idVenda")
	private Integer id;

	@ManyToMany(targetEntity = StatusVenda.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idStatusVenda", referencedColumnName="idStatusVenda", nullable=false)
	private StatusVenda statusVenda;
	
	@ManyToMany(targetEntity = Usuario.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioVenda", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuarioVenda;
	
	@ManyToMany(targetEntity = UsuarioCupom.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioCupom", referencedColumnName="idUsuarioCupom", nullable=false)
	private UsuarioCupom usuarioCupom;
	
	@ManyToOne(targetEntity = FormaPagamento.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idFormaPagamento", referencedColumnName="idFormaPagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtVenda", nullable=false)
	private Date dataVenda;
	
	@Column(name="vlVendaTotal", nullable=false)
	private BigDecimal valorTotal;
	
	/**
	 * Return the id 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter the id
	 * @param id the id to set
	 */
	public void setId(Integer codigo) {
		this.id = codigo;
	}
	/**
	 * Return the idStatusVenda 
	 * @return the idStatusVenda
	 */
	public Integer getIdStatusVenda() {
		return idStatusVenda;
	}
	/**
	 * Setter the idStatusVenda
	 * @param idStatusVenda the idStatusVenda to set
	 */
	public void setIdStatusVenda(Integer codigoStatusVenda) {
		this.idStatusVenda = codigoStatusVenda;
	}
	/**
	 * Return the idUsuarioVenda 
	 * @return the idUsuarioVenda
	 */
	public Integer getIdUsuarioVenda() {
		return idUsuarioVenda;
	}
	/**
	 * Setter the idUsuarioVenda
	 * @param idUsuarioVenda the idUsuarioVenda to set
	 */
	public void setIdUsuarioVenda(Integer codigoUsuarioVenda) {
		this.idUsuarioVenda = codigoUsuarioVenda;
	}
	/**
	 * Return the idUsuarioCupom 
	 * @return the idUsuarioCupom
	 */
	public Integer getIdUsuarioCupom() {
		return idUsuarioCupom;
	}
	/**
	 * Setter the idUsuarioCupom
	 * @param idUsuarioCupom the idUsuarioCupom to set
	 */
	public void setIdUsuarioCupom(Integer codigoUsuarioCupom) {
		this.idUsuarioCupom = codigoUsuarioCupom;
	}
	/**
	 * Return the idFormaPagamento 
	 * @return the idFormaPagamento
	 */
	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}
	/**
	 * Setter the idFormaPagamento
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(Integer codigoFormaPagamento) {
		this.idFormaPagamento = codigoFormaPagamento;
	}
	/**
	 * Return the dataVenda 
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	/**
	 * Setter the dataVenda
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	/**
	 * Return the valorTotal 
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	/**
	 * Setter the valorTotal
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
