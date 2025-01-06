 // JavaScript function to handle the form submission and validate user info
        function handleFormSubmit(event) {
            event.preventDefault();  // Prevent the form from submitting the traditional way

            // Get values from the form
            const userId = document.getElementById("userId").value;
            const password = document.getElementById("password").value;
            const date = document.getElementById("date").value;

            // Check if the entered userId and password are correct
            if (userId !== "Shradhanjali" || password !== "DearGoldy") {
                // If the credentials are incorrect, show an error message
                alert("Write correct User ID and Password!");
                return; // Prevent further processing and form submission
            }

            // Store user ID and password in localStorage (for demo purposes)
            localStorage.setItem("userId", userId);
            localStorage.setItem("password", password);

            // Optionally, display the user data (just for demonstration)
            alert(`User ID: ${userId}\nPassword: ${password}\nDate: ${date}`);

            // Redirect to the diary page (or any other page)
            window.location.href = "diary.html";
        }