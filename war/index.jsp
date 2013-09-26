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
//对pushlet的初始化，触发web.xml中的servlet。
PL._init();
//这里的监听的主题，必须在sources.properties中配置的对象中声明这个主题。
//sources.properties配置着事件源（EventSources），在服务器启动时会自动激活。
//可以通过服务器的启动记录查看得到。可以将这个文件放到WEB-INF目录下面或者classess目录下面都可以。
PL.joinListen('/wondersgroup/pushdemo');
function onData(event) {
//	alert(event.get("pushdemo"));
}
</script>
</head>

<body>
Hello World 
</body>
</html>