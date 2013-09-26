<html>
<head>
<title>HelloWorld</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="ajax-pushlet-client.js"></script>
<script type="text/javascript">
PL._init();
PL.joinListen('/system/jvm');
function onData(event) {
	alert(event.get("totalMemory"));
}
</script>
</head>
<body>

</body>
</html>