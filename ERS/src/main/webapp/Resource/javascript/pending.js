window.onload = function(){
    getRequests();
    document.getElementById("decideSubmit").addEventListener('click', appden);
}
function getRequests(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(xhttp.readyState==4 && xhttp.status ==200){
            console.log("readyState is 4!!! AND status is 200!!!");
            let requestObj = JSON.parse(xhttp.responseText);
            console.log(requestObj);
            ourDOMManipulation(requestObj);
        }
    }
    xhttp.open('POST', `http://localhost:9001/ERS/json/filterrequest`);

    obj = {
        "statusId": 1
    }
    let lilJson = JSON.stringify(obj);
    xhttp.send(lilJson);
}
function ourDOMManipulation(ourResponseObject){
    for(let i= 0; i < ourResponseObject.length; i++){
        let newTR = document.createElement("tr");
        let newTH = document.createElement("td");
        let newTD1 = document.createElement("td");
        let newTD2 = document.createElement("td");
        let newTD3 = document.createElement("td");
        let newTD4 = document.createElement("td");
        let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");
        let newTD8 = document.createElement("td");
        //step 2: populate our creations
        let myTextH = document.createTextNode('\u00A0\u00A0\u00A0\u00A0' + ourResponseObject[i].reimbId);
        let myTextD1 = document.createTextNode('$' + '\u0020' + ourResponseObject[i].reimbAmt);
        let myTextD2 = document.createTextNode(ourResponseObject[i].reimbSumbitted);
        let myTextD3 = document.createTextNode(ourResponseObject[i].reimbResolved);
        let myTextD4 = document.createTextNode(ourResponseObject[i].reimbDescription);
        let myTextD5 = document.createTextNode(ourResponseObject[i].reimbAuthor);
        let myTextD6 = document.createTextNode(ourResponseObject[i].resolvedBy);
        let myTextD7 = document.createTextNode(ourResponseObject[i].requestType);
        let myTextD8 = document.createTextNode(ourResponseObject[i].requestStatus);
        
        
        //all appending
        newTH.appendChild(myTextH);
        newTD1.appendChild(myTextD1);
        newTD2.appendChild(myTextD2);
        newTD3.appendChild(myTextD3);
        newTD4.appendChild(myTextD4);
        newTD5.appendChild(myTextD5);
        newTD6.appendChild(myTextD6);
        newTD7.appendChild(myTextD7);
        newTD8.appendChild(myTextD8);
        
        newTR.appendChild(newTH);
        newTR.appendChild(newTD1);
        newTR.appendChild(newTD2);
        newTR.appendChild(newTD3);
        newTR.appendChild(newTD4);
        newTR.appendChild(newTD5);
        newTR.appendChild(newTD6);
        newTR.appendChild(newTD7);
        newTR.appendChild(newTD8);
        
        
        let newSelection = document.querySelector("#requestTableBody");
        newSelection.appendChild(newTR);
    }
    
}
function appden(){
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function (){
            if(xhttp.readyState==4 && xhttp.status ==200){
                console.log("readyState is 4!!! AND status is 200!!!");
            }
        }
        if(document.getElementById("approve").checked){
            xhttp.open('POST', `http://localhost:9001/ERS/json/approverequest`);
        }
        if(document.getElementById("deny").checked){
            xhttp.open('POST', `http://localhost:9001/ERS/json/denyrequest`);
        }

        var id = +document.getElementById("requestid").value;
        obj = {
            "reimbId": id
        }
        let lilJson = JSON.stringify(obj);
        xhttp.send(lilJson);
    
   
}