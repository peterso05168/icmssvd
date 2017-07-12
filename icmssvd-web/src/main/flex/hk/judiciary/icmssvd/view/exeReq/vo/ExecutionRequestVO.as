package hk.judiciary.icmssvd.view.exeReq.vo
{
	import hk.judiciary.icmssvd.view.common.vo.BaseVO;
	import hk.judiciary.icmssvd.view.common.vo.DocumentTypeVO;

	[RemoteClass(alias="hk.judiciary.icmssvd.model.exeReq.biz.dto.ExecutionRequestDTO")]
	public class ExecutionRequestVO extends BaseVO
	{
		public var executionRequestId:int;
		public var requestId:int;
		public var documentType:DocumentTypeVO;
	}
}