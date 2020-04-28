<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://xmlns.jcp.org/jsf/passthrough"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets">

<ui:include src="WEB-INF/head.xhtml">
    <ui:param name="pageHeader" value="Product"/>
</ui:include>

<h:body>

    <ui:include src="WEB-INF/header.xhtml"/>

    <div class="container">
        <div class="row py-2">
            <div class="col-12">
                <h:form id="productForm">
                    <div class="form-group">
                        <h:outputLabel value="Name" for="name"/>
                        <h:inputText styleClass="form-control" id="name" name="name" placeholder="Enter name"
                                     value="#{productController.product.name}" required="true"
                                     requiredMessage="Name is required"/>
                    </div>
                    <div class="form-group">
                        <h:outputLabel value="Description" for="description"/>
                        <h:inputText styleClass="form-control" id="description" name="description"
                                     placeholder="Enter desription"
                                     value="#{productController.product.description}"/>
                    </div>
                    <div class="form-group">
                        <h:outputLabel value="Price" for="price"/>
                        <h:inputText p:type="number" styleClass="form-control" id="price" name="price"
                                     placeholder="Enter price"
                                     value="#{productController.product.price}">
                            <f:converter converterId="javax.faces.BigDecimal"/>
                        </h:inputText>
                    </div>
                    <h:commandButton value="Submit" styleClass="btn btn-primary"
                                     action="#{productController.saveProduct()}"/>
                </h:form>
            </div>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</h:body>

</html>