window.onload = function() {
	
	if(document.getElementById("regist")) {
		const $regist = document.getElementById("regist");
		$regist.onclick = function() {
			location.href = "/jsp/member/regist";
		}
	}
	
	if(document.getElementById("logout")) {
		const $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/jsp/member/logout";
		}
	}
	
	if(document.getElementById("update")) {
		const $update = document.getElementById("update");
		$update.onclick = function() {
			location.href = "/jsp/member/update";
		}
	}
	
	if(document.getElementById("writeNotice")) {
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function() {
			location.href = "/jsp/notice/insert";
		}
	}
	
	if(document.getElementById("cancelNotice")) {
		const $cancelNotice = document.getElementById("cancelNotice");
		$cancelNotice.onclick = function() {
			location.href = "/jsp/notice/list";
		}
	}
	
	if(document.getElementById("writeThumbnail")) {
		const $writeThumbnail = document.getElementById("writeThumbnail");
		$writeThumbnail.onclick = function() {
			location.href = "/jsp/thumbnail/insert";
		}
	}
	
}

















