<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="styler.css">
<script src = "https://www.gstatic.com/firebasejs/5.3.0/firebase.js"></script>
<script src = "https://www.gstatic.com/firebasejs/5.3.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.3.0/firebase-firestore.js"></script>
<script type="text/javascript" src="firebase.js"></script>
</script>
</head>

<body>
<script>
var naming;
var cityRef = db.collection('Donor').doc();

var setWithMerge = cityRef.set({
    name: naming,
    amount: amt,
    dateofdonation: dod,
    pancard: pancard,
    program: prg,
    resident: resident
}, { merge: true });
</script>