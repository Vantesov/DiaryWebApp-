
let modal = document.getElementById('modal');
let body = document.getElementsByTagName('body')[0];
let record_id_input = document.getElementById('record_id_input')

let textarea = document.getElementById("textarea");

function showModal(variable){
	let id = variable;
	console.log(id);
	modal.classList.add('modal_get_visible'); 
    body.classList.add('body_block'); 


    if ( id > 0 ) {

    	SendPostRequest("/Diary/pool/gettingRecord",id)

    } else {
    	record_id_input.value = -1;
    	textarea.value = "";
    }
}

function hideModal(){
	modal.classList.remove('modal_get_visible'); 
    body.classList.remove('body_block'); 
}



function CreateRequest()
{
    var Request = false;

    if (window.XMLHttpRequest)
    {
        Request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        try
        {
             Request = new ActiveXObject("Microsoft.XMLHTTP");
        }    
        catch (CatchException)
        {
             Request = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
 
    if (!Request)
    {
        alert("Невозможно создать XMLHttpRequest");
    }
    
    return Request;
} 


function SendPostRequest(r_path, r_args)
{
    var Request = CreateRequest();
    
    if (!Request)
    {
        return;
    }
    
    //Назначаем пользовательский обработчик
    Request.onreadystatechange = function()
    {
        //Если обмен данными завершен
        if (Request.readyState == 4)
        {
            let record = JSON.parse(Request.responseText);
            textarea.value = record.text;
            record_id_input.value = record.id;
        }
    }
    
    
    //Инициализируем соединение
    Request.open("post", r_path, true);
    Request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
     //Посылаем запрос
    Request.send("id=" + r_args);
    
} 
