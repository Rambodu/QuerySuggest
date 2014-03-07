<!DOCTYPE html>
<html lang="en">
<%
	String contextPath = request.getContextPath();
%>
<head>
<meta charset="utf-8">
<title>QuerySuggestionDemo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<!-- Le styles -->
<link href="<%=contextPath%>/css/bootstrap.css" rel="stylesheet">
</head>

<body>
	<div class="container-fluid">
		<form class="form-signin" action="#" method="post">
			<h2 class="form-signin-heading">Input Query</h2>
			<input type="text"  class="input-xlarge" id="suggestQuery" name="suggestQuery" data-provide="typeahead" placeholder="Search Query" autocomplete="off">
			
			<!-- <br /> --> 
			
			<!-- <input type="text" name="queryInput" id="query" placeholder="Search Query"
				class="input-block-level" id="query_input"> -->
				
				
			<button type="submit" class="btn btn-large btn-primary">Search!</button>
			<!-- 
			<br />
			<div class="progress" id="suggest_progress">
				<div class="bar bar-success" style="width: 10%;"></div>
			</div>
			<ul class="nav nav-tabs nav-stacked" id="suggest_ul">
			</ul> -->

			<!-- <div class="dropdown">
				<a class="dropdown-toggle" id="dLabel" role="button"
					data-toggle="dropdown" data-target="#" href="/page.html">
					Suggestions <b class="caret"></b>
				</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				</ul>
			</div> -->
		</form>

		<hr>

		<footer>
			<p align="center">&copy; Rambodu. 2014.3.8</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=contextPath%>/js/jquery.js"></script>
	<script src="<%=contextPath%>/js/bootstrap.js"></script>
	<script src="<%=contextPath%>/js/bootstrap.autocomplete.js"></script>
	<script src="<%=contextPath%>/js/jQuery.placeholder.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		$('input, textarea').placeholder();
		$('#suggestQuery').autocomplete({
			source:function(query,process){
				var matchCount = this.options.items;
				$.post("http://localhost:8080/querySuggestWebapp/s.do",{"q":query,"rows":10},function(respData){
					var suggestArray = eval(respData);
					return process(suggestArray);
				});
			}/* ,
			formatItem:function(item){
				alert(''+item);
				return item.suggestion;
			},
			setValue:function(item){
				return {'data-value':item,'real-value':item};
			} */
		});
		/* $("#goBtn").click(function(){
			alert("1");
		}); */
	});
	
		/* $(function() {
			//IE  
			if ($.browser.msie) {
				$("#query_input").get(0).attachEvent("onpropertychange", function(o) {
					alert(o.srcElement.value);
				});
				//非IE  
			} else {
				$("#query_input").get(0).addEventListener("input", function(o) {
					alert(o.target.value);
				}, false);
			}
		}); */

		/* function suggest(query,rows){
			var url = 'http://localhost:8080/querySuggestWebapp/s.do?q='+query+'&rows='+rows;
			 $.get(url, function (data, textStatus){
				//返回的 data 可以是 xmlDoc, jsonObj, html, text, 等等.
				//this; // 在这里this指向的是Ajax请求的选项配置信息，请参考下图
				alert(data);
				var suggestArray = eval("'"+data+"'");
				aleter(suggestArray[0].suggestion)
				alert(textStatus);//请求状态：success，error等等。
				//当然这里捕捉不到error，因为error的时候根本不会运行该回调函数
				//alert(this);
				});
		} */
		/* function showSuggestions() {
			// update suggestion list
			$('.typeahead').typeahead();
		} */
	</script>
</body>
</html>