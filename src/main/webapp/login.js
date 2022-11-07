const usernameEl=document.querySelector('#nombre');
const feoguapoEl=document.querySelector('#feoguapo');
const passwordEl=document.querySelector('#password');
const cPasswordEl=document.querySelector('#cPassword')
const emailEl=document.querySelector('#email');

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
        showError(usernameEl, 'Username cannot be blank.');
    } else if (!isBetween(username.length, min, max)) { //Despues comprueba que tenga la longitud permitida
        showError(usernameEl, `Username must be between ${min} and ${max} characters.`)
    } else {
        showSuccess(usernameEl);
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


form.addEventListener('submit', function (e){

    let isUsernameValid=checkUsername();
    let isPasswordValid=checkPassword();

    let isFormValid=isUsernameValid && isPasswordValid;

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
    }
});