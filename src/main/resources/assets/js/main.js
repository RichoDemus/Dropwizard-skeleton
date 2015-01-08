$(function()
{
	console.log("Hello World");
	$.getJSON("api/hello-world?name=Successful+Dropwizard+User", function(data)
	{
		console.log(data);
		$("#myDiv").text(data.content);
	});
});