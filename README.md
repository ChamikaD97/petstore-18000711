1. How to build and/or deploy the API

*)First clone the repo and open with inteliJ IDE and build it using JAVA 11
*)Then after if the API build successfull run the API.

2. How to run test suite

*) then after runing the API start the postman.

	--View--
		Set method to GET and set the URL as "http://localhost:8080/v1/pets/1"(Here 1 is the petId that needs details)
		and send then the response would apear at the bottom.

	--Insert--
		Set method to POST and set the URL as "http://localhost:8080/v1/pets/addPet" and select JSON type body as follows,

				{
           			 "PetAge": 25,
           			 "PetName": "Puppy",
            			 "PetType": "Dog"
        			}
			and send it.
			If it successfull it will return the JSON object that you have created and send,if the attemp is unsuccessfull
			"Erro 404" returns.

	--Delete--
		Set method to DELETE and set the URL as "http://localhost:8080/v1/pets/deletePet/1" (Here 1 is the petId that deleted).
		If it successfull returns "Successfully deleted" while "Unsuccessful" if not.


	--Update--
		Set method to DELETE and set the URL as "http://localhost:8080/v1/pets/edit/1" (Here 1 is the petId that updates).
		and select JSON type body as follows,
				
				{
           			 "PetAge": 20,
           			 "PetName": "Tom",
            			 "PetType": "Cat"
        			}
		
		If it successfull returns updated JSON object while returns "Unsuccessful" if not.


3. How to run a CURL/WGET command to test the APIs once deployed