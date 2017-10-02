/**
 * (通过调用Servlet)调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteBatchServlet.action")
	$("#mainForm").submit();
}

/**
 * 全选
 */
function allChose(cbobj) {
	var tags = document.getElementsByTagName("input");
	if (cbobj.checked) {
		for (i = 0; i < tags.length; i++) {
			if (tags[i].type == "checkbox" && tags[i].name == "id") {
				tags[i].checked = "true";
			}
		}
	} else {
		for (i = 0; i < tags.length; i++) {
			if (tags[i].type == "checkbox" && tags[i].name == "id") {
				tags[i].checked = false;
			}
		}
	}
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

//删除成功后提示
var elements = new Array(2);
document.write("dasdasdadsadasdasdsadsada");
originNum();
elementsChange();
function deleteComplete() {
	if (elements[0] != elements[1] && element[1] != null) {
		alert("删除成功");
	} else {
		document.write(elements[0]);
	}
}

function elementsChange() {
	var tb2 = document.getElementById("tb2");
	var tbLength = tb2.childNodes.length;
	elements[1] = tbLength;
	document.write(tbLength);
}

function originNum() {
	var tb = document.getElementById("tb2");
	var tbLength1 = tb.childNodes.length;
	elements[0] = tbLength1;
	deleteComplete();
	document.write(tbLength1);
}