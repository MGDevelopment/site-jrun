package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Articulos generated by hbm2java
 */
public class Articulos  implements java.io.Serializable {


     private long idArticulo;
     private Editores editoresByIdEditor;
     private Editores editoresByIdCoeditor;
     private String titulo;
     private String codigoProveedor;
     private String descripcion;
     private Date fechaAlta;
     private String idioma;
     private Integer paginas;
     private Short altura;
     private Short largo;
     private Short ancho;
     private Integer peso;
     private BigDecimal precioVentaVigente;
     private BigDecimal precioCompraVigente;
     private Byte desdeEdad;
     private Byte hastaEdad;
     private String marca;
     private String agotado;
     private String activo;
     private String archivoEnSite;
     private String archivoImagen;
     private String archivoCapitulo;
     private Long idArticuloSite;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private String idTipoArticulo;
     private Long idUsrAlta;
     private Long idUsrModi;
     private String idMonedaCompra;
     private String idMonedaVenta;
     private long idProveedor;
     private Long idColeccion;
     private String idImpuesto;
     private String novedad;
     private String stock;
     private String esTexto;
     private String estadoIngreso;
     private byte categoriaSeccion;
     private byte categoriaGrupo;
     private byte categoriaFamilia;
     private byte categoriaSubfamilia;
     private Byte idActividadIibb;
     private Long nroEdicion;
     private String formatoTapas;
     private String formatoSobrecubierta;
     private String coleccionDirector;
     private String coleccionSerie;
     private String coleccionNumero;
     private Integer nroVolumen;
     private Integer totalVolumenes;
     private String traductor;
     private String compilador;
     private String ilustrador;
     private String codExtVisual;
     private String auxvarchar01;
     private String auxvarchar02;
     private String auxvarchar03;
     private String auxvarchar04;
     private String auxvarchar05;
     private String auxvarchar06;
     private String auxvarchar07;
     private String auxvarchar08;
     private String auxvarchar09;
     private String auxvarchar10;
     private String auxvarchar11;
     private String auxvarchar12;
     private String auxvarchar13;
     private String auxvarchar14;
     private String auxvarchar15;
     private BigDecimal auxnumber01;
     private BigDecimal auxnumber02;
     private BigDecimal auxnumber03;
     private BigDecimal auxnumber04;
     private BigDecimal auxnumber05;
     private BigDecimal auxnumber06;
     private BigDecimal auxnumber07;
     private BigDecimal auxnumber08;
     private BigDecimal auxnumber09;
     private BigDecimal auxnumber10;
     private BigDecimal auxnumber11;
     private BigDecimal auxnumber12;
     private BigDecimal auxnumber13;
     private BigDecimal auxnumber14;
     private BigDecimal auxnumber15;
     private String auxflag01;
     private String auxflag02;
     private String auxflag03;
     private String auxflag04;
     private String auxflag05;
     private String auxflag06;
     private String auxflag07;
     private String auxflag08;
     private String auxflag09;
     private String auxflag10;
     private String auxflag11;
     private String auxflag12;
     private String auxflag13;
     private String auxflag14;
     private String auxflag15;
     private String auxlongchar01;
     private String auxlongchar02;
     private BigDecimal idDisponibilidad;
     private String habilitadoTematika;
     private Set masVendidosSeccions = new HashSet(0);
     private Set carritoCompras = new HashSet(0);
     private Set carritoChequeObsequios = new HashSet(0);
     private Set listasTmkArticuloses = new HashSet(0);
     private Set visitasArticulosDetalles = new HashSet(0);
     private Set masVendidosSubfamilias = new HashSet(0);
     private Set itemOrdens = new HashSet(0);
     private Set articulosTemasMusicaleses = new HashSet(0);
     private LogCambioArticulos logCambioArticulos;
     private Set masVendidosFamilias = new HashSet(0);
     private Set articulosTextosXPalabras = new HashSet(0);
     private Set itemsMovimientoses = new HashSet(0);
     private Set masVendidosGrupos = new HashSet(0);
     private Set articulosArticulosTextoses = new HashSet(0);
     private Set carritoListaDeseoses = new HashSet(0);
     private Set carritoPromocions = new HashSet(0);

    public Articulos() {
    }

	
    public Articulos(long idArticulo, Editores editoresByIdEditor, String titulo, Date fechaAlta, String idioma, String usrAlta, Date FAlta, String idTipoArticulo, String idMonedaCompra, String idMonedaVenta, long idProveedor, String novedad, String stock, String esTexto, String estadoIngreso, byte categoriaSeccion, byte categoriaGrupo, byte categoriaFamilia, byte categoriaSubfamilia, String habilitadoTematika) {
        this.idArticulo = idArticulo;
        this.editoresByIdEditor = editoresByIdEditor;
        this.titulo = titulo;
        this.fechaAlta = fechaAlta;
        this.idioma = idioma;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.idTipoArticulo = idTipoArticulo;
        this.idMonedaCompra = idMonedaCompra;
        this.idMonedaVenta = idMonedaVenta;
        this.idProveedor = idProveedor;
        this.novedad = novedad;
        this.stock = stock;
        this.esTexto = esTexto;
        this.estadoIngreso = estadoIngreso;
        this.categoriaSeccion = categoriaSeccion;
        this.categoriaGrupo = categoriaGrupo;
        this.categoriaFamilia = categoriaFamilia;
        this.categoriaSubfamilia = categoriaSubfamilia;
        this.habilitadoTematika = habilitadoTematika;
    }
    public Articulos(long idArticulo, Editores editoresByIdEditor, Editores editoresByIdCoeditor, String titulo, String codigoProveedor, String descripcion, Date fechaAlta, String idioma, Integer paginas, Short altura, Short largo, Short ancho, Integer peso, BigDecimal precioVentaVigente, BigDecimal precioCompraVigente, Byte desdeEdad, Byte hastaEdad, String marca, String agotado, String activo, String archivoEnSite, String archivoImagen, String archivoCapitulo, Long idArticuloSite, String usrAlta, Date FAlta, String usrModi, Date FModi, String idTipoArticulo, Long idUsrAlta, Long idUsrModi, String idMonedaCompra, String idMonedaVenta, long idProveedor, Long idColeccion, String idImpuesto, String novedad, String stock, String esTexto, String estadoIngreso, byte categoriaSeccion, byte categoriaGrupo, byte categoriaFamilia, byte categoriaSubfamilia, Byte idActividadIibb, Long nroEdicion, String formatoTapas, String formatoSobrecubierta, String coleccionDirector, String coleccionSerie, String coleccionNumero, Integer nroVolumen, Integer totalVolumenes, String traductor, String compilador, String ilustrador, String codExtVisual, String auxvarchar01, String auxvarchar02, String auxvarchar03, String auxvarchar04, String auxvarchar05, String auxvarchar06, String auxvarchar07, String auxvarchar08, String auxvarchar09, String auxvarchar10, String auxvarchar11, String auxvarchar12, String auxvarchar13, String auxvarchar14, String auxvarchar15, BigDecimal auxnumber01, BigDecimal auxnumber02, BigDecimal auxnumber03, BigDecimal auxnumber04, BigDecimal auxnumber05, BigDecimal auxnumber06, BigDecimal auxnumber07, BigDecimal auxnumber08, BigDecimal auxnumber09, BigDecimal auxnumber10, BigDecimal auxnumber11, BigDecimal auxnumber12, BigDecimal auxnumber13, BigDecimal auxnumber14, BigDecimal auxnumber15, String auxflag01, String auxflag02, String auxflag03, String auxflag04, String auxflag05, String auxflag06, String auxflag07, String auxflag08, String auxflag09, String auxflag10, String auxflag11, String auxflag12, String auxflag13, String auxflag14, String auxflag15, String auxlongchar01, String auxlongchar02, BigDecimal idDisponibilidad, String habilitadoTematika, Set masVendidosSeccions, Set carritoCompras, Set carritoChequeObsequios, Set listasTmkArticuloses, Set visitasArticulosDetalles, Set masVendidosSubfamilias, Set itemOrdens, Set articulosTemasMusicaleses, LogCambioArticulos logCambioArticulos, Set masVendidosFamilias, Set articulosTextosXPalabras, Set itemsMovimientoses, Set masVendidosGrupos, Set articulosArticulosTextoses, Set carritoListaDeseoses, Set carritoPromocions) {
       this.idArticulo = idArticulo;
       this.editoresByIdEditor = editoresByIdEditor;
       this.editoresByIdCoeditor = editoresByIdCoeditor;
       this.titulo = titulo;
       this.codigoProveedor = codigoProveedor;
       this.descripcion = descripcion;
       this.fechaAlta = fechaAlta;
       this.idioma = idioma;
       this.paginas = paginas;
       this.altura = altura;
       this.largo = largo;
       this.ancho = ancho;
       this.peso = peso;
       this.precioVentaVigente = precioVentaVigente;
       this.precioCompraVigente = precioCompraVigente;
       this.desdeEdad = desdeEdad;
       this.hastaEdad = hastaEdad;
       this.marca = marca;
       this.agotado = agotado;
       this.activo = activo;
       this.archivoEnSite = archivoEnSite;
       this.archivoImagen = archivoImagen;
       this.archivoCapitulo = archivoCapitulo;
       this.idArticuloSite = idArticuloSite;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idTipoArticulo = idTipoArticulo;
       this.idUsrAlta = idUsrAlta;
       this.idUsrModi = idUsrModi;
       this.idMonedaCompra = idMonedaCompra;
       this.idMonedaVenta = idMonedaVenta;
       this.idProveedor = idProveedor;
       this.idColeccion = idColeccion;
       this.idImpuesto = idImpuesto;
       this.novedad = novedad;
       this.stock = stock;
       this.esTexto = esTexto;
       this.estadoIngreso = estadoIngreso;
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.idActividadIibb = idActividadIibb;
       this.nroEdicion = nroEdicion;
       this.formatoTapas = formatoTapas;
       this.formatoSobrecubierta = formatoSobrecubierta;
       this.coleccionDirector = coleccionDirector;
       this.coleccionSerie = coleccionSerie;
       this.coleccionNumero = coleccionNumero;
       this.nroVolumen = nroVolumen;
       this.totalVolumenes = totalVolumenes;
       this.traductor = traductor;
       this.compilador = compilador;
       this.ilustrador = ilustrador;
       this.codExtVisual = codExtVisual;
       this.auxvarchar01 = auxvarchar01;
       this.auxvarchar02 = auxvarchar02;
       this.auxvarchar03 = auxvarchar03;
       this.auxvarchar04 = auxvarchar04;
       this.auxvarchar05 = auxvarchar05;
       this.auxvarchar06 = auxvarchar06;
       this.auxvarchar07 = auxvarchar07;
       this.auxvarchar08 = auxvarchar08;
       this.auxvarchar09 = auxvarchar09;
       this.auxvarchar10 = auxvarchar10;
       this.auxvarchar11 = auxvarchar11;
       this.auxvarchar12 = auxvarchar12;
       this.auxvarchar13 = auxvarchar13;
       this.auxvarchar14 = auxvarchar14;
       this.auxvarchar15 = auxvarchar15;
       this.auxnumber01 = auxnumber01;
       this.auxnumber02 = auxnumber02;
       this.auxnumber03 = auxnumber03;
       this.auxnumber04 = auxnumber04;
       this.auxnumber05 = auxnumber05;
       this.auxnumber06 = auxnumber06;
       this.auxnumber07 = auxnumber07;
       this.auxnumber08 = auxnumber08;
       this.auxnumber09 = auxnumber09;
       this.auxnumber10 = auxnumber10;
       this.auxnumber11 = auxnumber11;
       this.auxnumber12 = auxnumber12;
       this.auxnumber13 = auxnumber13;
       this.auxnumber14 = auxnumber14;
       this.auxnumber15 = auxnumber15;
       this.auxflag01 = auxflag01;
       this.auxflag02 = auxflag02;
       this.auxflag03 = auxflag03;
       this.auxflag04 = auxflag04;
       this.auxflag05 = auxflag05;
       this.auxflag06 = auxflag06;
       this.auxflag07 = auxflag07;
       this.auxflag08 = auxflag08;
       this.auxflag09 = auxflag09;
       this.auxflag10 = auxflag10;
       this.auxflag11 = auxflag11;
       this.auxflag12 = auxflag12;
       this.auxflag13 = auxflag13;
       this.auxflag14 = auxflag14;
       this.auxflag15 = auxflag15;
       this.auxlongchar01 = auxlongchar01;
       this.auxlongchar02 = auxlongchar02;
       this.idDisponibilidad = idDisponibilidad;
       this.habilitadoTematika = habilitadoTematika;
       this.masVendidosSeccions = masVendidosSeccions;
       this.carritoCompras = carritoCompras;
       this.carritoChequeObsequios = carritoChequeObsequios;
       this.listasTmkArticuloses = listasTmkArticuloses;
       this.visitasArticulosDetalles = visitasArticulosDetalles;
       this.masVendidosSubfamilias = masVendidosSubfamilias;
       this.itemOrdens = itemOrdens;
       this.articulosTemasMusicaleses = articulosTemasMusicaleses;
       this.logCambioArticulos = logCambioArticulos;
       this.masVendidosFamilias = masVendidosFamilias;
       this.articulosTextosXPalabras = articulosTextosXPalabras;
       this.itemsMovimientoses = itemsMovimientoses;
       this.masVendidosGrupos = masVendidosGrupos;
       this.articulosArticulosTextoses = articulosArticulosTextoses;
       this.carritoListaDeseoses = carritoListaDeseoses;
       this.carritoPromocions = carritoPromocions;
    }
   
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Editores getEditoresByIdEditor() {
        return this.editoresByIdEditor;
    }
    
    public void setEditoresByIdEditor(Editores editoresByIdEditor) {
        this.editoresByIdEditor = editoresByIdEditor;
    }
    public Editores getEditoresByIdCoeditor() {
        return this.editoresByIdCoeditor;
    }
    
    public void setEditoresByIdCoeditor(Editores editoresByIdCoeditor) {
        this.editoresByIdCoeditor = editoresByIdCoeditor;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCodigoProveedor() {
        return this.codigoProveedor;
    }
    
    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getIdioma() {
        return this.idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public Integer getPaginas() {
        return this.paginas;
    }
    
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    public Short getAltura() {
        return this.altura;
    }
    
    public void setAltura(Short altura) {
        this.altura = altura;
    }
    public Short getLargo() {
        return this.largo;
    }
    
    public void setLargo(Short largo) {
        this.largo = largo;
    }
    public Short getAncho() {
        return this.ancho;
    }
    
    public void setAncho(Short ancho) {
        this.ancho = ancho;
    }
    public Integer getPeso() {
        return this.peso;
    }
    
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    public BigDecimal getPrecioVentaVigente() {
        return this.precioVentaVigente;
    }
    
    public void setPrecioVentaVigente(BigDecimal precioVentaVigente) {
        this.precioVentaVigente = precioVentaVigente;
    }
    public BigDecimal getPrecioCompraVigente() {
        return this.precioCompraVigente;
    }
    
    public void setPrecioCompraVigente(BigDecimal precioCompraVigente) {
        this.precioCompraVigente = precioCompraVigente;
    }
    public Byte getDesdeEdad() {
        return this.desdeEdad;
    }
    
    public void setDesdeEdad(Byte desdeEdad) {
        this.desdeEdad = desdeEdad;
    }
    public Byte getHastaEdad() {
        return this.hastaEdad;
    }
    
    public void setHastaEdad(Byte hastaEdad) {
        this.hastaEdad = hastaEdad;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAgotado() {
        return this.agotado;
    }
    
    public void setAgotado(String agotado) {
        this.agotado = agotado;
    }
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
    }
    public String getArchivoEnSite() {
        return this.archivoEnSite;
    }
    
    public void setArchivoEnSite(String archivoEnSite) {
        this.archivoEnSite = archivoEnSite;
    }
    public String getArchivoImagen() {
        return this.archivoImagen;
    }
    
    public void setArchivoImagen(String archivoImagen) {
        this.archivoImagen = archivoImagen;
    }
    public String getArchivoCapitulo() {
        return this.archivoCapitulo;
    }
    
    public void setArchivoCapitulo(String archivoCapitulo) {
        this.archivoCapitulo = archivoCapitulo;
    }
    public Long getIdArticuloSite() {
        return this.idArticuloSite;
    }
    
    public void setIdArticuloSite(Long idArticuloSite) {
        this.idArticuloSite = idArticuloSite;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public String getIdTipoArticulo() {
        return this.idTipoArticulo;
    }
    
    public void setIdTipoArticulo(String idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }
    public Long getIdUsrAlta() {
        return this.idUsrAlta;
    }
    
    public void setIdUsrAlta(Long idUsrAlta) {
        this.idUsrAlta = idUsrAlta;
    }
    public Long getIdUsrModi() {
        return this.idUsrModi;
    }
    
    public void setIdUsrModi(Long idUsrModi) {
        this.idUsrModi = idUsrModi;
    }
    public String getIdMonedaCompra() {
        return this.idMonedaCompra;
    }
    
    public void setIdMonedaCompra(String idMonedaCompra) {
        this.idMonedaCompra = idMonedaCompra;
    }
    public String getIdMonedaVenta() {
        return this.idMonedaVenta;
    }
    
    public void setIdMonedaVenta(String idMonedaVenta) {
        this.idMonedaVenta = idMonedaVenta;
    }
    public long getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Long getIdColeccion() {
        return this.idColeccion;
    }
    
    public void setIdColeccion(Long idColeccion) {
        this.idColeccion = idColeccion;
    }
    public String getIdImpuesto() {
        return this.idImpuesto;
    }
    
    public void setIdImpuesto(String idImpuesto) {
        this.idImpuesto = idImpuesto;
    }
    public String getNovedad() {
        return this.novedad;
    }
    
    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
    public String getStock() {
        return this.stock;
    }
    
    public void setStock(String stock) {
        this.stock = stock;
    }
    public String getEsTexto() {
        return this.esTexto;
    }
    
    public void setEsTexto(String esTexto) {
        this.esTexto = esTexto;
    }
    public String getEstadoIngreso() {
        return this.estadoIngreso;
    }
    
    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public byte getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(byte categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public byte getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(byte categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public byte getCategoriaSubfamilia() {
        return this.categoriaSubfamilia;
    }
    
    public void setCategoriaSubfamilia(byte categoriaSubfamilia) {
        this.categoriaSubfamilia = categoriaSubfamilia;
    }
    public Byte getIdActividadIibb() {
        return this.idActividadIibb;
    }
    
    public void setIdActividadIibb(Byte idActividadIibb) {
        this.idActividadIibb = idActividadIibb;
    }
    public Long getNroEdicion() {
        return this.nroEdicion;
    }
    
    public void setNroEdicion(Long nroEdicion) {
        this.nroEdicion = nroEdicion;
    }
    public String getFormatoTapas() {
        return this.formatoTapas;
    }
    
    public void setFormatoTapas(String formatoTapas) {
        this.formatoTapas = formatoTapas;
    }
    public String getFormatoSobrecubierta() {
        return this.formatoSobrecubierta;
    }
    
    public void setFormatoSobrecubierta(String formatoSobrecubierta) {
        this.formatoSobrecubierta = formatoSobrecubierta;
    }
    public String getColeccionDirector() {
        return this.coleccionDirector;
    }
    
    public void setColeccionDirector(String coleccionDirector) {
        this.coleccionDirector = coleccionDirector;
    }
    public String getColeccionSerie() {
        return this.coleccionSerie;
    }
    
    public void setColeccionSerie(String coleccionSerie) {
        this.coleccionSerie = coleccionSerie;
    }
    public String getColeccionNumero() {
        return this.coleccionNumero;
    }
    
    public void setColeccionNumero(String coleccionNumero) {
        this.coleccionNumero = coleccionNumero;
    }
    public Integer getNroVolumen() {
        return this.nroVolumen;
    }
    
    public void setNroVolumen(Integer nroVolumen) {
        this.nroVolumen = nroVolumen;
    }
    public Integer getTotalVolumenes() {
        return this.totalVolumenes;
    }
    
    public void setTotalVolumenes(Integer totalVolumenes) {
        this.totalVolumenes = totalVolumenes;
    }
    public String getTraductor() {
        return this.traductor;
    }
    
    public void setTraductor(String traductor) {
        this.traductor = traductor;
    }
    public String getCompilador() {
        return this.compilador;
    }
    
    public void setCompilador(String compilador) {
        this.compilador = compilador;
    }
    public String getIlustrador() {
        return this.ilustrador;
    }
    
    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }
    public String getCodExtVisual() {
        return this.codExtVisual;
    }
    
    public void setCodExtVisual(String codExtVisual) {
        this.codExtVisual = codExtVisual;
    }
    public String getAuxvarchar01() {
        return this.auxvarchar01;
    }
    
    public void setAuxvarchar01(String auxvarchar01) {
        this.auxvarchar01 = auxvarchar01;
    }
    public String getAuxvarchar02() {
        return this.auxvarchar02;
    }
    
    public void setAuxvarchar02(String auxvarchar02) {
        this.auxvarchar02 = auxvarchar02;
    }
    public String getAuxvarchar03() {
        return this.auxvarchar03;
    }
    
    public void setAuxvarchar03(String auxvarchar03) {
        this.auxvarchar03 = auxvarchar03;
    }
    public String getAuxvarchar04() {
        return this.auxvarchar04;
    }
    
    public void setAuxvarchar04(String auxvarchar04) {
        this.auxvarchar04 = auxvarchar04;
    }
    public String getAuxvarchar05() {
        return this.auxvarchar05;
    }
    
    public void setAuxvarchar05(String auxvarchar05) {
        this.auxvarchar05 = auxvarchar05;
    }
    public String getAuxvarchar06() {
        return this.auxvarchar06;
    }
    
    public void setAuxvarchar06(String auxvarchar06) {
        this.auxvarchar06 = auxvarchar06;
    }
    public String getAuxvarchar07() {
        return this.auxvarchar07;
    }
    
    public void setAuxvarchar07(String auxvarchar07) {
        this.auxvarchar07 = auxvarchar07;
    }
    public String getAuxvarchar08() {
        return this.auxvarchar08;
    }
    
    public void setAuxvarchar08(String auxvarchar08) {
        this.auxvarchar08 = auxvarchar08;
    }
    public String getAuxvarchar09() {
        return this.auxvarchar09;
    }
    
    public void setAuxvarchar09(String auxvarchar09) {
        this.auxvarchar09 = auxvarchar09;
    }
    public String getAuxvarchar10() {
        return this.auxvarchar10;
    }
    
    public void setAuxvarchar10(String auxvarchar10) {
        this.auxvarchar10 = auxvarchar10;
    }
    public String getAuxvarchar11() {
        return this.auxvarchar11;
    }
    
    public void setAuxvarchar11(String auxvarchar11) {
        this.auxvarchar11 = auxvarchar11;
    }
    public String getAuxvarchar12() {
        return this.auxvarchar12;
    }
    
    public void setAuxvarchar12(String auxvarchar12) {
        this.auxvarchar12 = auxvarchar12;
    }
    public String getAuxvarchar13() {
        return this.auxvarchar13;
    }
    
    public void setAuxvarchar13(String auxvarchar13) {
        this.auxvarchar13 = auxvarchar13;
    }
    public String getAuxvarchar14() {
        return this.auxvarchar14;
    }
    
    public void setAuxvarchar14(String auxvarchar14) {
        this.auxvarchar14 = auxvarchar14;
    }
    public String getAuxvarchar15() {
        return this.auxvarchar15;
    }
    
    public void setAuxvarchar15(String auxvarchar15) {
        this.auxvarchar15 = auxvarchar15;
    }
    public BigDecimal getAuxnumber01() {
        return this.auxnumber01;
    }
    
    public void setAuxnumber01(BigDecimal auxnumber01) {
        this.auxnumber01 = auxnumber01;
    }
    public BigDecimal getAuxnumber02() {
        return this.auxnumber02;
    }
    
    public void setAuxnumber02(BigDecimal auxnumber02) {
        this.auxnumber02 = auxnumber02;
    }
    public BigDecimal getAuxnumber03() {
        return this.auxnumber03;
    }
    
    public void setAuxnumber03(BigDecimal auxnumber03) {
        this.auxnumber03 = auxnumber03;
    }
    public BigDecimal getAuxnumber04() {
        return this.auxnumber04;
    }
    
    public void setAuxnumber04(BigDecimal auxnumber04) {
        this.auxnumber04 = auxnumber04;
    }
    public BigDecimal getAuxnumber05() {
        return this.auxnumber05;
    }
    
    public void setAuxnumber05(BigDecimal auxnumber05) {
        this.auxnumber05 = auxnumber05;
    }
    public BigDecimal getAuxnumber06() {
        return this.auxnumber06;
    }
    
    public void setAuxnumber06(BigDecimal auxnumber06) {
        this.auxnumber06 = auxnumber06;
    }
    public BigDecimal getAuxnumber07() {
        return this.auxnumber07;
    }
    
    public void setAuxnumber07(BigDecimal auxnumber07) {
        this.auxnumber07 = auxnumber07;
    }
    public BigDecimal getAuxnumber08() {
        return this.auxnumber08;
    }
    
    public void setAuxnumber08(BigDecimal auxnumber08) {
        this.auxnumber08 = auxnumber08;
    }
    public BigDecimal getAuxnumber09() {
        return this.auxnumber09;
    }
    
    public void setAuxnumber09(BigDecimal auxnumber09) {
        this.auxnumber09 = auxnumber09;
    }
    public BigDecimal getAuxnumber10() {
        return this.auxnumber10;
    }
    
    public void setAuxnumber10(BigDecimal auxnumber10) {
        this.auxnumber10 = auxnumber10;
    }
    public BigDecimal getAuxnumber11() {
        return this.auxnumber11;
    }
    
    public void setAuxnumber11(BigDecimal auxnumber11) {
        this.auxnumber11 = auxnumber11;
    }
    public BigDecimal getAuxnumber12() {
        return this.auxnumber12;
    }
    
    public void setAuxnumber12(BigDecimal auxnumber12) {
        this.auxnumber12 = auxnumber12;
    }
    public BigDecimal getAuxnumber13() {
        return this.auxnumber13;
    }
    
    public void setAuxnumber13(BigDecimal auxnumber13) {
        this.auxnumber13 = auxnumber13;
    }
    public BigDecimal getAuxnumber14() {
        return this.auxnumber14;
    }
    
    public void setAuxnumber14(BigDecimal auxnumber14) {
        this.auxnumber14 = auxnumber14;
    }
    public BigDecimal getAuxnumber15() {
        return this.auxnumber15;
    }
    
    public void setAuxnumber15(BigDecimal auxnumber15) {
        this.auxnumber15 = auxnumber15;
    }
    public String getAuxflag01() {
        return this.auxflag01;
    }
    
    public void setAuxflag01(String auxflag01) {
        this.auxflag01 = auxflag01;
    }
    public String getAuxflag02() {
        return this.auxflag02;
    }
    
    public void setAuxflag02(String auxflag02) {
        this.auxflag02 = auxflag02;
    }
    public String getAuxflag03() {
        return this.auxflag03;
    }
    
    public void setAuxflag03(String auxflag03) {
        this.auxflag03 = auxflag03;
    }
    public String getAuxflag04() {
        return this.auxflag04;
    }
    
    public void setAuxflag04(String auxflag04) {
        this.auxflag04 = auxflag04;
    }
    public String getAuxflag05() {
        return this.auxflag05;
    }
    
    public void setAuxflag05(String auxflag05) {
        this.auxflag05 = auxflag05;
    }
    public String getAuxflag06() {
        return this.auxflag06;
    }
    
    public void setAuxflag06(String auxflag06) {
        this.auxflag06 = auxflag06;
    }
    public String getAuxflag07() {
        return this.auxflag07;
    }
    
    public void setAuxflag07(String auxflag07) {
        this.auxflag07 = auxflag07;
    }
    public String getAuxflag08() {
        return this.auxflag08;
    }
    
    public void setAuxflag08(String auxflag08) {
        this.auxflag08 = auxflag08;
    }
    public String getAuxflag09() {
        return this.auxflag09;
    }
    
    public void setAuxflag09(String auxflag09) {
        this.auxflag09 = auxflag09;
    }
    public String getAuxflag10() {
        return this.auxflag10;
    }
    
    public void setAuxflag10(String auxflag10) {
        this.auxflag10 = auxflag10;
    }
    public String getAuxflag11() {
        return this.auxflag11;
    }
    
    public void setAuxflag11(String auxflag11) {
        this.auxflag11 = auxflag11;
    }
    public String getAuxflag12() {
        return this.auxflag12;
    }
    
    public void setAuxflag12(String auxflag12) {
        this.auxflag12 = auxflag12;
    }
    public String getAuxflag13() {
        return this.auxflag13;
    }
    
    public void setAuxflag13(String auxflag13) {
        this.auxflag13 = auxflag13;
    }
    public String getAuxflag14() {
        return this.auxflag14;
    }
    
    public void setAuxflag14(String auxflag14) {
        this.auxflag14 = auxflag14;
    }
    public String getAuxflag15() {
        return this.auxflag15;
    }
    
    public void setAuxflag15(String auxflag15) {
        this.auxflag15 = auxflag15;
    }
    public String getAuxlongchar01() {
        return this.auxlongchar01;
    }
    
    public void setAuxlongchar01(String auxlongchar01) {
        this.auxlongchar01 = auxlongchar01;
    }
    public String getAuxlongchar02() {
        return this.auxlongchar02;
    }
    
    public void setAuxlongchar02(String auxlongchar02) {
        this.auxlongchar02 = auxlongchar02;
    }
    public BigDecimal getIdDisponibilidad() {
        return this.idDisponibilidad;
    }
    
    public void setIdDisponibilidad(BigDecimal idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    public String getHabilitadoTematika() {
        return this.habilitadoTematika;
    }
    
    public void setHabilitadoTematika(String habilitadoTematika) {
        this.habilitadoTematika = habilitadoTematika;
    }
    public Set getMasVendidosSeccions() {
        return this.masVendidosSeccions;
    }
    
    public void setMasVendidosSeccions(Set masVendidosSeccions) {
        this.masVendidosSeccions = masVendidosSeccions;
    }
    public Set getCarritoCompras() {
        return this.carritoCompras;
    }
    
    public void setCarritoCompras(Set carritoCompras) {
        this.carritoCompras = carritoCompras;
    }
    public Set getCarritoChequeObsequios() {
        return this.carritoChequeObsequios;
    }
    
    public void setCarritoChequeObsequios(Set carritoChequeObsequios) {
        this.carritoChequeObsequios = carritoChequeObsequios;
    }
    public Set getListasTmkArticuloses() {
        return this.listasTmkArticuloses;
    }
    
    public void setListasTmkArticuloses(Set listasTmkArticuloses) {
        this.listasTmkArticuloses = listasTmkArticuloses;
    }
    public Set getVisitasArticulosDetalles() {
        return this.visitasArticulosDetalles;
    }
    
    public void setVisitasArticulosDetalles(Set visitasArticulosDetalles) {
        this.visitasArticulosDetalles = visitasArticulosDetalles;
    }
    public Set getMasVendidosSubfamilias() {
        return this.masVendidosSubfamilias;
    }
    
    public void setMasVendidosSubfamilias(Set masVendidosSubfamilias) {
        this.masVendidosSubfamilias = masVendidosSubfamilias;
    }
    public Set getItemOrdens() {
        return this.itemOrdens;
    }
    
    public void setItemOrdens(Set itemOrdens) {
        this.itemOrdens = itemOrdens;
    }
    public Set getArticulosTemasMusicaleses() {
        return this.articulosTemasMusicaleses;
    }
    
    public void setArticulosTemasMusicaleses(Set articulosTemasMusicaleses) {
        this.articulosTemasMusicaleses = articulosTemasMusicaleses;
    }
    public LogCambioArticulos getLogCambioArticulos() {
        return this.logCambioArticulos;
    }
    
    public void setLogCambioArticulos(LogCambioArticulos logCambioArticulos) {
        this.logCambioArticulos = logCambioArticulos;
    }
    public Set getMasVendidosFamilias() {
        return this.masVendidosFamilias;
    }
    
    public void setMasVendidosFamilias(Set masVendidosFamilias) {
        this.masVendidosFamilias = masVendidosFamilias;
    }
    public Set getArticulosTextosXPalabras() {
        return this.articulosTextosXPalabras;
    }
    
    public void setArticulosTextosXPalabras(Set articulosTextosXPalabras) {
        this.articulosTextosXPalabras = articulosTextosXPalabras;
    }
    public Set getItemsMovimientoses() {
        return this.itemsMovimientoses;
    }
    
    public void setItemsMovimientoses(Set itemsMovimientoses) {
        this.itemsMovimientoses = itemsMovimientoses;
    }
    public Set getMasVendidosGrupos() {
        return this.masVendidosGrupos;
    }
    
    public void setMasVendidosGrupos(Set masVendidosGrupos) {
        this.masVendidosGrupos = masVendidosGrupos;
    }
    public Set getArticulosArticulosTextoses() {
        return this.articulosArticulosTextoses;
    }
    
    public void setArticulosArticulosTextoses(Set articulosArticulosTextoses) {
        this.articulosArticulosTextoses = articulosArticulosTextoses;
    }
    public Set getCarritoListaDeseoses() {
        return this.carritoListaDeseoses;
    }
    
    public void setCarritoListaDeseoses(Set carritoListaDeseoses) {
        this.carritoListaDeseoses = carritoListaDeseoses;
    }
    public Set getCarritoPromocions() {
        return this.carritoPromocions;
    }
    
    public void setCarritoPromocions(Set carritoPromocions) {
        this.carritoPromocions = carritoPromocions;
    }




}


