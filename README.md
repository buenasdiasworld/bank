# bank
simple RESTful app

API

GET

/transaction
/transaction/id

/account
/account/id

/holder
/holder/id

POST

/transaction

DELETE

/account/id

you can test the app via TALEND API TESTER

example request body for POST /transaction 

{
    "from_account": 3333,
    "to_account": 4444,
    "amount": "1"
}
