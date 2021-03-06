package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;

/**
 * ItemsLiquidaciones generated by hbm2java
 */
public class ItemsLiquidaciones  implements java.io.Serializable {


     private ItemsLiquidacionesId id;
     private ItemsMovimientos itemsMovimientos;
     private long idArticulo;
     private BigDecimal idLiquidacionAlianza;
     private BigDecimal porcComisionAlianza;
     private String tipoComisionAlianza;
     private String estado;

    public ItemsLiquidaciones() {
    }

	
    public ItemsLiquidaciones(ItemsMovimientos itemsMovimientos, long idArticulo) {
        this.itemsMovimientos = itemsMovimientos;
        this.idArticulo = idArticulo;
    }
    public ItemsLiquidaciones(ItemsMovimientos itemsMovimientos, long idArticulo, BigDecimal idLiquidacionAlianza, BigDecimal porcComisionAlianza, String tipoComisionAlianza, String estado) {
       this.itemsMovimientos = itemsMovimientos;
       this.idArticulo = idArticulo;
       this.idLiquidacionAlianza = idLiquidacionAlianza;
       this.porcComisionAlianza = porcComisionAlianza;
       this.tipoComisionAlianza = tipoComisionAlianza;
       this.estado = estado;
    }
   
    public ItemsLiquidacionesId getId() {
        return this.id;
    }
    
    public void setId(ItemsLiquidacionesId id) {
        this.id = id;
    }
    public ItemsMovimientos getItemsMovimientos() {
        return this.itemsMovimientos;
    }
    
    public void setItemsMovimientos(ItemsMovimientos itemsMovimientos) {
        this.itemsMovimientos = itemsMovimientos;
    }
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public BigDecimal getIdLiquidacionAlianza() {
        return this.idLiquidacionAlianza;
    }
    
    public void setIdLiquidacionAlianza(BigDecimal idLiquidacionAlianza) {
        this.idLiquidacionAlianza = idLiquidacionAlianza;
    }
    public BigDecimal getPorcComisionAlianza() {
        return this.porcComisionAlianza;
    }
    
    public void setPorcComisionAlianza(BigDecimal porcComisionAlianza) {
        this.porcComisionAlianza = porcComisionAlianza;
    }
    public String getTipoComisionAlianza() {
        return this.tipoComisionAlianza;
    }
    
    public void setTipoComisionAlianza(String tipoComisionAlianza) {
        this.tipoComisionAlianza = tipoComisionAlianza;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


