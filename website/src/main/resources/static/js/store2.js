/**
 * Created by jarma on 6/6/2017.
 */
var app = window.app || {},
    business_paypal = 'armanpela@gmail.com';// aquí va tu correo electrónico de paypal

(function($){
    'use strict';

    //no coflict con underscores

    app.init = function(){
        //totalItems totalAmount
        var total = 0,
            items = 0

        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []} ;

        if(undefined != cart.items && cart.items != null && cart.items != '' && cart.items.length > 0){
            _.forEach(cart.items, function(n, key) {
                items = (items + n.cant)
                total = total  + (n.cant * n.price)
            });

        }

        $('#totalItems').text(items)
        $('.totalAmount').text('$ '+total+ ' USD')

    }

    app.createProducts = function(){
        var productos = [
                {
                    id : 1,
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    name : 'Libertad 5oz',
                    price : 299.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 4
                },
                {
                    id : 2,
                    name : 'Libertad 5oz',
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    price : 199.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 2
                },
                {
                    id : 3,
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    name : 'Libertad 5oz',
                    price : 299.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 4
                },
                {
                    id : 4,
                    name : 'Libertad 5oz',
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    price : 199.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 2
                },
                {
                    id : 5,
                    name : 'Libertad 5oz',
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    price : 99.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 1
                },
                {
                    id : 6,
                    name : 'Libertad 5oz',
                    img : 'http://libertadproof.com/wp-content/uploads/2016/02/87952_Obv.jpg',
                    price : 80.00,
                    desc : 'Libertad 5oz BU 1998 Contains 1 Libertad 5oz BU brilliant uncirculated .999 fine Silver. In capsule The same coin as you see in this picture. We only Ship to the US, and is FREE Shipping Shipping time 5-7 business days via UPS express with tracking and insurance. Payments only via Paypal.',
                    stock : 0
                }
            ],
            wrapper = $('.productosWrapper'),
            contenido = ''

        for(var i = 0; i < productos.length; i++){

            if(productos[i].stock > 0){
                contenido+= '<li>'
                contenido+= '   <div class="coin-wrapper">'
                contenido+= '		<img src="'+productos[i].img+'" alt="'+productos[i].name+'">'
                contenido+= '		<span class="large-12 columns product-details">'
                contenido+= '			<h3>'+productos[i].name+'<br/><br/>Precio: <span class="price">$ '+productos[i].price+' USD</span></h3>'
                contenido+= '			<h3>Tenemos: <span class="stock">'+productos[i].stock+'</span></h3>'
                contenido+= '		</span>'
                contenido+= '		<a class="large-12 columns btn submit ladda-button prod-'+productos[i].id+'" data-style="slide-right" onclick="app.addtoCart('+productos[i].id+');">Añadir a la canasta</a>'
                contenido+= '		<div class="clearfix"></div>'
                contenido+= '   </div>'
                contenido+= '</li>'
            }
        }

        wrapper.html(contenido)

        localStorage.setItem('productos',JSON.stringify(productos))
    }

    app.addtoCart = function(id){
        debugger;
        var l = Ladda.create( document.querySelector( '.prod-'+id ) );

        l.start();
        var productos = JSON.parse(localStorage.getItem('productos')),
            producto = _.find(productos,{ 'id' : id }),
            cant = 1
        if(cant <= producto.stock){
            if(undefined != producto){
                if(cant > 0){
                    setTimeout(function(){
                        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []} ;
                        app.searchProd(cart,producto.id,parseInt(cant),producto.name,producto.price,producto.img,producto.stock)
                        l.stop();
                    },2000)
                }else{
                    alert('Solo se permiten cantidades mayores a cero')
                }
            }else{
                alert('Oops! algo malo ocurrió, inténtalo de nuevo más tarde')
            }
        }else{
            alert('No se pueden añadir más de este producto')
        }
    }

    app.searchProd = function(cart,id,cant,name,price,img,available){
        //si le pasamos un valor negativo a la cantidad, se descuenta del carrito
        var curProd = _.find(cart.items, { 'id': id })

        if(undefined != curProd && curProd != null){
            //ya existe el producto, aÃ±adimos uno mÃ¡s a su cantidad
            if(curProd.cant < available){
                curProd.cant = parseInt(curProd.cant + cant)
            }else{
                alert('No se pueden añadir más de este producto')
            }

        }else{
            //sino existe lo agregamos al carrito
            var prod = {
                id : id,
                cant : cant,
                name : name,
                price : price,
                img : img,
                available : available
            }
            cart.items.push(prod)

        }
        localStorage.setItem('cart',JSON.stringify(cart))
        app.init()
        app.getProducts()
        app.updatePayForm()
    }

    app.getProducts = function(){
        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []},
            msg = '',
            wrapper = $('.cart'),
            total = 0
        wrapper.html('')

        if(undefined == cart || null == cart || cart == '' || cart.items.length == 0){
            wrapper.html('<li>Tu canasta está vacía</li>');
            $('.cart').css('left','-400%')
        }else{
            var items = '';
            _.forEach(cart.items, function(n, key) {

                total = total  + (n.cant * n.price)
                items += '<li>'
                items += '<img src="'+n.img+'" />'
                // width:100px;overflow:hidden;height:50px;line-height:50px;
                items += '<h3 class="title"><div style="width:200px;overflow:hidden;height: 19px">'+n.name+'</div><span class="price">'+n.cant+' x $ '+n.price+' USD</span> <button class="add" onclick="app.updateItem('+n.id+','+n.available+')"><i class="icon ion-minus-circled"></i></button> <button onclick="app.deleteProd('+n.id+')" ><i class="icon ion-close-circled"></i></button><div class="clearfix"></div></h3>'
                items += '</li>'
            });

            //agregar el total al carrito
            items += '<li id="total">Total : $ '+total+' USD <div id="submitForm"></div></li>'
            wrapper.html(items)
            //$('.cart').css('left','-600%')
        }
        if(cartNextVisible == true)
            $('.cart').hide();
    }

    app.updateItem = function(id,available){
        //resta uno a la cantidad del carrito de compras
        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []} ,
            curProd = _.find(cart.items, { 'id': id })
        //actualizar el carrito
        curProd.cant = curProd.cant - 1;
        //validar que la cantidad no sea menor a 0
        if(curProd.cant > 0){
            localStorage.setItem('cart',JSON.stringify(cart))
            app.init()
            app.getProducts()
            app.updatePayForm()
        }else{
            app.deleteProd(id,true)
        }
    }

    app.delete = function(id){
        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []} ;
        var curProd = _.find(cart.items, { 'id': id })
        _.remove(cart.items, curProd);
        localStorage.setItem('cart',JSON.stringify(cart))
        app.init()
        app.getProducts()
        app.updatePayForm()
    }

    app.deleteProd = function(id,remove){
        if(undefined != id && id > 0){

            if(remove == true){
                app.delete(id)
            }else{
                var conf = confirm('¿Deseas eliminar este producto?')
                if(conf){
                    app.delete(id)
                }
            }

        }
    }

    app.updatePayForm = function(){
        //eso va a generar un formulario dinamico para paypal
        //con los productos y sus precios
        var cart = (JSON.parse(localStorage.getItem('cart')) != null) ? JSON.parse(localStorage.getItem('cart')) : {items : []} ;
        var statics = '<form action="https://www.paypal.com/cgi-bin/webscr" method="post"><input type="hidden" name="cmd" value="_cart"><input type="hidden" name="upload" value="1"><input type="hidden" name="currency_code" value="USD" /><input type="hidden" name="business" value="'+business_paypal+'">',
            dinamic = '',
            wrapper = $('#submitForm')

        wrapper.html('')

        if(undefined != cart && null != cart && cart != ''){
            var i = 1;
            _.forEach(cart.items, function(prod, key) {
                dinamic += '<input type="hidden" name="item_name_'+i+'" value="'+prod.name+'">'
                dinamic += '<input type="hidden" name="amount_'+i+'" value="'+prod.price+'">'
                dinamic += '<input type="hidden" name="item_number_'+i+'" value="'+prod.id+'" />'
                dinamic += '<input type="hidden" name="quantity_'+i+'" value="'+prod.cant+'" />'
                i++;
            })

            statics += dinamic + '<button type="submit" class="pay">Pagar &nbsp;<i class="ion-chevron-right"></i></button></form>'

            wrapper.html(statics)
        }
    }

    app.expandCart = function(){
        if(cartNextVisible){
            $('.cart').show();
        }
        else{
            $('.cart').hide();
        }
        cartNextVisible = !cartNextVisible;
        getHome("/cartNextVisible/"+cartNextVisible);
        return false;
    }

    $(document).ready(function(){
        app.init()
        app.getProducts()
        app.updatePayForm()
        //app.createProducts()//loads products on local storage
    })
})(jQuery)


function repos(imgs) {
    imgs.each(function (i, o) {
        var imgw = $(o).width()
        var boxw = $(o).parent('div').width()
        var imgh = $(o).height()
        var boxh = $(o).parent('div').outerHeight()

        if (imgw > boxw) {
            $(o).css('left', ((imgw / 2) - (boxw / 2)) * -1)
        } else {
            $(o).css('left', 0)
        }

        if (imgh > boxh) {
            $(o).css('top', ((imgh / 2) - (boxh / 2)) * -1)
        } else {
            $(o).css('top', 0)
        }
    })
}
$(window).resize(function () {
    repos($('.field-content img'))
})

repos($('.field-content img'))