const usernameEl=document.querySelector('#nombre');
const feoguapoEl=document.querySelector('#feoguapo');
const passwordEl=document.querySelector('#password');
const cPasswordEl=document.querySelector('#cPassword')
const emailEl=document.querySelector('#email');
const nombrePropioEl=document.querySelector('#nombrePropio');
const apellidosEl=document.querySelector('#apellidos');
const fechaEl=document.querySelector('#fecha');

const form=document.querySelector('#form');

//Funcion es requerido
const isRequired = value => value === '' ? false : true;
//Funcion para comprobar el tamaño
const isBetween = (length, min, max) => length < min || length > max ? false : true;
//Funcion para comprobar si el email es valido
const isEmailValid = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};
//Funcion para comprobar si la contraseña es fuerte(Strong)
const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
};

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
const checkUsername = () => {

    let valid = false;
    const min = 3,
        max = 25;
    const username = usernameEl.value.trim();

    if (!isRequired(username)) { //Primero comprueba que se ha metido el username
        showError(usernameEl, 'El nickname no puede estar vacío.');
    } else if (!isBetween(username.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(usernameEl, `El nickname debe estar entre ${min} y ${max} carácteres.`)
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
}

const checkFecha = () => {

    let valid = false;

    const fecha = fechaEl.value.trim();

    if (!isRequired(fecha)) { //Primero comprueba que se ha metido el username
        showError(fechaEl, 'Introduce una fecha correcta.');
    } else {
        showSuccess(fechaEl);
        valid = true;
    }
    return valid;
}
const checkNombrePropio = () => {

    let valid = false;
    const min = 1,
        max = 50;
    const nombrePropio = nombrePropioEl.value.trim();

    if (!isRequired(nombrePropio)) { //Primero comprueba que se ha metido el username
        showError(nombrePropioEl, 'El nombre no puede estar vacio.');
    } else if (!isBetween(nombrePropio.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(nombrePropioEl, `El nombre debe estar entre ${min} y ${max} carácteres.`)
    } else {
        showSuccess(nombrePropioEl);
        valid = true;
    }
    return valid;
}

const checkApellidos = () => {

    let valid = false;
    const min = 3,
        max = 50;
    const apellidos = apellidosEl.value.trim();

    if (!isRequired(apellidos)) { //Primero comprueba que se ha metido el username
        showError(apellidosEl, 'El campo no puede estar vacio.');
    } else if (!isBetween(apellidos.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(apellidosEl, `El campo debe estar entre ${min} y ${max} carácteres.`)
    } else {
        showSuccess(apellidosEl);
        valid = true;
    }
    return valid;
}

 //Funcion para validar el email
const checkEmail = () => {
    let valid = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, 'El email no puede estar vacio.');
    } else if (!isEmailValid(email)) {
        showError(emailEl, 'El email no es válido.')
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
}

const checkPassword= () => { //Funcion para validar la contraseña

    let valid = false;
    const password = passwordEl.value.trim();

    if (!isRequired(password)) {
        showError(passwordEl, 'El campo no puede estar en blanco');
    } else if (!isPasswordSecure(password)) { //Comprobamos si la contraseña es fuerte
        showError(passwordEl, `La contraseña debe tener 8 caracteres, una mayuscula, una minuscula, un numero y un caracter especial (!@#$%^&*)`)
    } else {
        showSuccess(passwordEl);
        valid = true;
    }
    return valid;
}

const checkConfirmPassword = () => { //Funcion para confirmar contraseña
    let valid = false;
    // check confirm password
    const confirmPassword = cPasswordEl.value.trim();
    const password = passwordEl.value.trim();

    if (!isRequired(confirmPassword)) {
        showError(cPasswordEl, 'Introduce la contraseña');
    } else if (password !== confirmPassword) {
        showError(cPasswordEl, 'La contraseña no coincide');
    } else {
        showSuccess(cPasswordEl);
        valid = true;
    }

    return valid;
};

form.addEventListener('submit', function (e){

    let isUsernameValid=checkUsername();
    let isPasswordValid=checkPassword();
    let isPasswordConfirmed=checkConfirmPassword();
    let isEmailConfirmed=checkEmail();
    let isNombreConfirmed=checkNombrePropio();
    let isApellidosConfirmed=checkApellidos();
    let isFechaConfirmed=checkFecha();

    let isFormValid=isUsernameValid && isFechaConfirmed && isApellidosConfirmed && isNombreConfirmed && isPasswordValid && isPasswordConfirmed && isEmailConfirmed;

    if (!isFormValid){
        e.preventDefault();
    }

})

form.addEventListener('input', function (e) {
    switch (e.target.id) {
        case 'nombre':
            checkUsername();
            break;

        case 'password':{
            checkPassword();
            break;
        }
        case 'fecha':{
            checkFecha();
            break;
        }
        case 'nombrePropio':{
            checkNombrePropio();
            break;
        }
        case 'cPassword':{
            checkConfirmPassword();
            break;
        }
        case 'email':{
            checkEmail();
            break;
        }
        case 'apellidos':{
            checkApellidos();
            break;
        }
    }
});