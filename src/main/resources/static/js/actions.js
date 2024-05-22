function addSample() {

    const name = document.getElementById('titleTD').value;
    const description = document.getElementById('descriptionTD').value;
    const number = document.getElementById('numberTD').value;

    const jsonBody = {
        name,
        description,
        number
    };

    postSample(jsonBody);
}

function displayResponse(response) {

    const resultArea = document.getElementById("resultContainer"),
        tbl = document.createElement("table"),
        tblHead = document.createElement("thead"),
        tblBody = document.createElement("tbody"),
        title = document.createElement("a");
    tbl.id = "resultTable";
    title.text = "Result";
    title.className = "titles";

    let map = new Map(Object.entries(response));

    /** Create Header Row **/
    const tblHeadRow = tblHead.insertRow();
    const tblHeadRowCell1 = document.createElement("th");
    const tblHeadRowCell2 = document.createElement("th");
    tblHeadRow.append(tblHeadRowCell1, tblHeadRowCell2);
    tblHeadRowCell1.appendChild(document.createTextNode("Category"));
    tblHeadRowCell2.appendChild(document.createTextNode("Amount"));

    /** Insert Dynamic table rows in the table body */
    for (let i = 0; i < map.size; i++) {
        const tr = tblBody.insertRow();
        for (let j = 0; j < 2; j++) {
            const td = tr.insertCell();
            if (j === 0) {
                td.appendChild(document.createTextNode(Array.from(map.keys())[i]));
            } else if (j === 1) {
                td.appendChild(document.createTextNode(map.get(Array.from(map.keys())[i])));
            }
        }
    }
    tbl.appendChild(tblHead);
    tbl.appendChild(tblBody);

    resultArea.appendChild(title);
    resultArea.appendChild(tbl);
    resultArea.style.visibility = 'visible';
}

function getSample(id) {
    $.ajax({
        'type': 'GET',
        'url': '/sample/' + id,
        'contentType': 'application/json',
        'success': function(response)
        {
            displayResponse(response);      // TODO
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}

function getSamples() {
    $.ajax({
        'type': 'GET',
        'url': '/sample',
        'contentType': 'application/json',
        'success': function(response)
        {
            displayResponse(response);      // TODO
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}

function postSample(jsonBody) {
    $.ajax({
        'type': 'POST',
        'url': '/sample',
        'contentType': 'application/json',
        'data': JSON.stringify(jsonBody),
        'success': function(response)
        {
            displayResponse(response); // TODO
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}

function putSample(jsonBody, id) {
    $.ajax({
        'type': 'PUT',
        'url': '/sample/' + id,
        'contentType': 'application/json',
        'data': JSON.stringify(jsonBody),
        'success': function(response)
        {
            displayResponse(response); // TODO
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}

function deleteSample(id) {
    $.ajax({
        'type': 'DELETE',
        'url': '/sample/' + id,
        'contentType': 'application/json',
        'success': function(response)
        {
            displayResponse(response);      // TODO
        },
        'error': function(xhr, status, error)
        {
            console.log('Error on submitting API request:', xhr, status, error);
        }
    });
}