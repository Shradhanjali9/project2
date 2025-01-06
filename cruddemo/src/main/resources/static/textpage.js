 //define API base URL
  const apiBaseUrl = 'http://localhost:8080/api/userEntries';

  // Display current date in the header (top right)
  const dateElement = document.getElementById('current-date');
  const currentDate = new Date().toLocaleDateString();
  dateElement.textContent = currentDate;

  // Buttons functionality
  const textArea = document.getElementById('text-area');
  const saveButton = document.getElementById('save-btn');
  const editButton = document.getElementById('edit-btn');
  const clearButton = document.getElementById('clear-btn');

  // Save button: Save the current text in the textarea
  saveButton.addEventListener('click', function() {
      const textContent= textArea.value;

//     alert('Text saved: ' + savedText);     Placeholder for actual saving logic
//    textArea.disabled = true;               Disable textarea after saving
//     editButton.disabled = false;           Enable Edit button

//send a post request to save the text

  fetch(apiBaseUrl,{
  method:'post',
  header:{
    'Content-type':'application/json'
   },
     body:JSON.stringify(textContent)
  })
  .then(response => response.json())
  .then(data => {
     alert('Text saved!);
     textArea.disabled = true;
     editButton.disabled = false;
     })
     .catch(error => {
     console.error('Error saving text :',error);
     });
    });
  // Edit button: Enable editing again
  editButton.addEventListener('click', function() {
      textArea.disabled = false;  // Enable textarea for editing
      editButton.disabled = true;  // Disable Edit button while editing
  });

  // Clear button: Clear the text in the textarea
  clearButton.addEventListener('click', function() {
      textArea.value = '';  // Clear text area
  });