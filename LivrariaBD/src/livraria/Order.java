package livraria;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Book book;
    private ShippingInfo shippingInfo;
    private User user;
    private String compra;
    private BillingInfo billingInfo;
    private int id;
    private int idUsu;
    private int idLiv;
    private Date date;
    private Time time;
    List<Book> books = new ArrayList<>();
    
    public void addBook(Book book){
        books.add(book);
    }
    
    public boolean removerBook(Book book){
        return books.remove(book);
    }
    
    
    //Métodos de Operação
    
    public boolean modify(){
        return false;
    }
    
    public boolean checkAvailibility(){
        return false;
    }
    
    public boolean isFullFilled(){
        if(book!=null && shippingInfo!=null && billingInfo!=null && user!=null){
            return true;
        }
        return false;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdLiv() {
        return idLiv;
    }

    public void setIdLiv(int idLiv) {
        this.idLiv = idLiv;
    }
    
}
