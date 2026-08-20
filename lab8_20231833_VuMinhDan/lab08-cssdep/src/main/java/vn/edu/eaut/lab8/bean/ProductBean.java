package vn.edu.eaut.lab8.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import vn.edu.eaut.lab8.model.Product;

import java.io.Serializable;

@Named("productBean")
@SessionScoped
public class ProductBean implements Serializable {
    private Product product = new Product();

    public String save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công",
                        "Đã lưu sản phẩm: " + product.getTen()));
        product = new Product();
        return null;
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
