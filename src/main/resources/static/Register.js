function CreateAccount()
{
event.preventDefault();
	let password= document.getElementById("password").value
	let confirmpassword= document.getElementById("confirmpassword").value
	let isvalid =true
	if(password != confirmpassword)
		{
			let messageMatch =document.getElementById("pwid")
			messageMatch.style.color ="red"
			messageMatch.innerText="Password Not Matched"
			isvalid=false
		}

		if(password.length <8)
			{
				let messageData =document.getElementById("pid")
				messageData.style.color ="red"
				messageData.innerText="Password Length Should be Greater Than 8"
				isvalid=false
			}
		
	let email =document.getElementById("emailid").value
	if( !email.endsWith("@gmail.com"))
		{
			//alert("Email Should End with @gmail.com")
			let message =document.getElementById("msg")
			message.style.color ="red"
			message.innerText="Email Should End with @gmail.com"
			isvalid=false
		}
		if(isvalid)
			{
				alert("Details Look Good ,You Can Proceed With Account Creation !!")
				
				let uName = document.getElementById("username").value
								let passwd = document.getElementById("password").value
								let Eemail = document.getElementById("emailid").value
								
								fetch('/createaccount', {
							        method: 'POST',
							        headers: {
							            'Content-Type': 'application/json',
							        },
							        body: JSON.stringify({ username: uName, password: passwd ,email:Eemail }),
							    })
							    .then(response => response.json())
							    .then(data => {
									//document.getElementById('responsemessage').style.color='red';
							        //document.getElementById('responsemessage').innerText = data.message;
									window.location.href="/login";
							    })
							    .catch(error => console.error('Error:', error));	
			}
			
	
}