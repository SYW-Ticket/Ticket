var http = function(config) {
	var dtd = $.Deferred();
	$.ajax(config).then(function(data) {
		dtd.resolve(data);
	}, function() {
		alert("请求失败");
		dtd.reject();
	});
	return dtd.promise();
};

var Ajax = {
	get: function(url) {
		return http({
			url: url,
			type: 'GET'
		});
	},
	post: function(url, content) {
		return http({
			url: url,
			type: 'POST',
			data: content,
			headers: {
				'Content-type': 'application/json'
			}
		});
	},
	update: function(url, content) {
		return http({
			url: url,
			type: 'PUT',
			data: content,
			headers: {
				'Content-type': 'application/json'
			}
		});
	},
	delete: function(url) {
		return http({
			url: url,
			type: 'DELETE'
		});
	}
};