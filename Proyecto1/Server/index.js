var express = require("express");
var bodyParser = require("body-parser");
var app = express();

app.use(bodyParser.urlencoded({ extended: true }));




app.get("/dogs/:breed", (req, res) => {
    for (var i = 0; i < list.length; i++) {
        if (list[i].breed == req.params.breed) {
            res.send(
                list[i]
            )
        }
        
    }
});
app.get("/list", (req,res)=> {
    res.send(

    list

    )
})
const port = 40000;
app.listen(port, () => {
    console.log("Running ON  http://localhost:" + port);
});



var list = [
    { "breed": "Golden Retriever", "name": "Nana" },
    { "breed": "Beagle", "name": "Junior" },
    { "breed": "Boston Terrier", "name":"Iggy"},
    { "breed": "Boxer", "name": "Diablo" },
    { "breed": "Eurasier", "name": "Laika" },
    { "breed": "Great Dane", "name": "Danny" },
    { "breed": "Papillon", "name": "Becky" },
    { "breed": "Pitbull", "name": "Carlos" },
    { "breed": "Pug", "name": "Godo" },
    { "breed": "Rottweiler", "name": "Lassie" },
    { "breed": "Saluki", "name": "Kenai" },
    { "breed": "Shiba Inu", "name": "Ginny" },
    { "breed": "Greyhound", "name": "Rufo" },
    { "breed": "Chusky", "name": "Gordis" },
    { "breed": "Pomeranian", "name": "Perry" },
    {"breed": "Chihuahua", "name":  "Branian"},

];