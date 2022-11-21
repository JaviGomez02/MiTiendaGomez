const nameEl=document.querySelector('#nombre');
const descriptionEl=document.querySelector('#description');
const priceEl=document.querySelector('#price');
const stockEl=document.querySelector('#stock')

console.log(stockEl);

const form=document.querySelector('#form');

//Funcion es requerido
const isRequired = value => value === '' ? false : true;
//Funcion para comprobar el tamaño
const isBetween = (length, min, max) => length < min || length > max ? false : true;

//Funcion para marcar el error
const showError = (input, message) => {
    // get the form-field element
    const formField = input.parentElement;
    // add the error class
    formField.classList.remove('success');
    formField.classList.add('error');

    // show the error message
    const error = formField.querySelector('small');
    error.textContent = message;
};
//Funcion para mostrar que no hay error
const showSuccess = (input) => {
    // get the form-field element
    const formField = input.parentElement;

    // remove the error class
    formField.classList.remove('error');
    formField.classList.add('success');

    // hide the error message
    const error = formField.querySelector('small');
    error.textContent = '';
}

//Funcion para validar el username
const checkName = () => {

    let valid = false;
    const min = 2,
        max = 25;
    const name = nameEl.value.trim();

    if (!isRequired(name)) { //Primero comprueba que se ha metido el username
        showError(nameEl, 'El campo no puede estar vacio.');
    } else if (!isBetween(name.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(nameEl, `El nombre debe tener entre ${min} y ${max} caracteres.`)
    } else {
        showSuccess(nameEl);
        valid = true;
    }
    return valid;
}

const checkDescription = () => {

    let valid = false;
    const min = 10,
        max = 200;
    const description = descriptionEl.value.trim();

    if (!isRequired(description)) { //Primero comprueba que se ha metido el username
        showError(descriptionEl, 'El campo no puede estar vacio.');
    } else if (!isBetween(description.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(descriptionEl, `La descripcion debe tener entre ${min} y ${max} caracteres.`)
    } else {
        showSuccess(descriptionEl);
        valid = true;
    }
    return valid;
}

const checkPrice = () => {

    let valid = false;
    const min = 1,
        max = 1000;
    const price = priceEl.value.trim();

    if (!isRequired(price)) { 
        showError(priceEl, 'El campo no puede estar vacio.');
    } else if (!isBetween(parseFloat(price), min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(priceEl, `El precio debe estar entre ${min} y ${max}.`) 
    } else {
        showSuccess(priceEl);
        valid = true;
    }
    return valid;
}

const checkStock = () => {

    let valid = false;
    const min = 1;
    const stock = stockEl.value.trim();

    if (!isRequired(stock)) { 
        showError(stockEl, 'El campo no puede estar vacio.');
    } else if (!isBetween(parseFloat(stock), min)) { //Despues comprueba que tenga la longitud permitida
        showError(stockEl, `El stock debe ser mayor a 0.`) 
    } else {
        showSuccess(stockEl);
        valid = true;
    }
    return valid;
}

form.addEventListener('submit', function (e){

    let isNameValid=checkName();
    let isDescriptionValid=checkDescription();
	let isPriceValid=checkPrice();
	let isStockValid=checkStock();

    let isFormValid=isNameValid && isDescriptionValid && isPriceValid && isStockValid;

    if (!isFormValid){
        e.preventDefault();
    }

})

form.addEventListener('input', function (e) {
    switch (e.target.id) {
        case 'nombre':
            checkName();
            break;
        case 'description':{
            checkDescription();
            break;
        }
        case 'price':{
            checkPrice();
            break;
        }
        case 'stock':{
            checkStock();
            break;
        }
    }
});


