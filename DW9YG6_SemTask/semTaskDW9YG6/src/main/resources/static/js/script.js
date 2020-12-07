$(function() {
	$("#hospitalTable").on("click", "tr", function () {
		document.querySelectorAll("tr.selected").forEach(function(row) {
			row.classList.remove("selected");
		});
	$(this).addClass("selected");
});
})

