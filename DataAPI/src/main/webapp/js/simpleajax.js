/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function ajaxFunction(url,containerid, value)
{
    url = url + '?passingValue=' + value;
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else
    {
        alert("Your browser does not support XMLHTTP!");
    }

    xmlhttp.onreadystatechange=function()
    {
        loadpage(xmlhttp, containerid, value);
    }

    xmlhttp.open('GET', url, true);
    xmlhttp.send(null);
}

function loadpage(xmlhttp, containerid, value) {
    
    if (xmlhttp.readyState == 4 && (xmlhttp.status==200 || window.location.href.indexOf("http")==-1)) {
        document.getElementById(containerid).innerHTML=xmlhttp.responseText;
    }
    
}