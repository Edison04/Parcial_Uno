package Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable{
    private String codigo;
    private String nombreProducto;
    private double valor;
    private String exento;
    private String categoria;
    private String descripcion;

    public Producto(String cod, String nombre, double valor, String exento, String categ, String descripcion){
        this.setCodigo(cod);
        this.setNombreProducto(nombre);
        this.setValor(valor);
        this.setExento(exento);
        this.setCategoria(categ);
        this.setDescripcion(descripcion);
    }

    protected Producto(Parcel in) {
        codigo = in.readString();
        nombreProducto = in.readString();
        valor = in.readDouble();
        exento = in.readString();
        categoria = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getExento() {
        return exento;
    }

    public void setExento(String exento) {
        this.exento = exento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Código='" + codigo + "\n" +
                "Nombre del Producto='" + nombreProducto + "\n" +
                "Valor=" + valor + "\n" +
                "Exento='" + exento + "\n" +
                "Categoria='" + categoria;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(nombreProducto);
        dest.writeDouble(valor);
        dest.writeString(exento);
        dest.writeString(categoria);
        dest.writeString(descripcion);
    }
}
