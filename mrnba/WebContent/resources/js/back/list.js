/**
 * Invoke deleteBatchPlayer method in back-end by temporary form url
 */
function deleteBatchPlayer(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchPlayer.action");
	$("#mainForm").submit();
}