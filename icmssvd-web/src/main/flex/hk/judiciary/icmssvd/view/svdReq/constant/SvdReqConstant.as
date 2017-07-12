package hk.judiciary.icmssvd.view.svdReq.constant
{
	public class SvdReqConstant
	{
		public static const DEFAULT_DATE_PATTERN:String="DD/MM/YYYY";
		
		public static const DEFAULT_DAY_PATTERN:String = "EEE";
		
		public static const DEFAULT_TIME_PATTERN:String = "JJ:NN";
		
		public static const DEFAULT_DATE_TIME_PATTERN:String="DD/MM/YYYY JJ:NN";
		
		public static const REQUEST_SERVICE_TYPE_NAME_FRIST:String = "1st Service";
		public static const REQUEST_SERVICE_TYPE_NAME_RESERVICE:String = "Re-Service";
		
		public static const COURT_LEVEL_TYPE_DISTRICT:String = "DC";
		public static const COURT_LEVEL_TYPE_MAGISTRATES:String = "MC";
		
		public static const ALL:String = "-All-";
		
		public static const PROJECT_ID:String = "ICMSSVD";
		public static const COURTDIARY_PROJECT_ID:String = "ICMSCDY";
		
		public static const COURTDIARY_FUNCTION_ID:String = "CDY-CDY-50030";
		
		public static const DC_DETAIL_FUNCTION_ID:String = "SVD-SVD-00030";
		public static const MC_DETAIL_FUNCTION_ID:String = "SVD-SVD-00040";
		
		public static const EXECUTION_DETAIL_FUNCTION_ID:String = "SVD-SVD-00220";
		
		public static const DC_PROOF_DETAIL_FUNCTION_ID:String = "SVD-SVD-00130";
		public static const MC_PROOF_DETAIL_FUNCTION_ID:String = "SVD-SVD-00140";
		
		public static const PROOF_FUNCTION_ID:String = "SVD-SVD-00050";
		
		public static const SERVICE_REQUEST_DETAIL:String = "serviceRequestDetail";
		public static const POS_REQUEST_DETAIL:String = "posRequestDetail";
		public static const EXECUTION_REQUEST_DETAIL:String = "executionRequestDetail";
		public static const PARAM_FUNCTION:String = "func";
		
		public static const HONG_KONG_ISLAND:String = "Hong Kong Island";
		public static const KOWLOON:String = "Kowloon";
		public static const NEW_TERRITORIES:String = "New Territories";
		
		public static const BAILIFF_CODE:String = "BAI";
		public static const POLICE_CODE:String = "HKPF";
		public static const POST_OFFICE_CODE:String = "PSO";
		
		public static const REQUEST_SERVICE_TYPE_FRIST:int = 1;// 1st Service
		public static const REQUEST_SERVICE_TYPE_RESERVICE:int = 2;// Re-Service
		
		public static const SERVICE_MODE_CODE_PERSONAL:String = "PS";// Personal Service
		public static const SERVICE_MODE_CODE_REGISTERED:String = "RP";// Registered Post
		public static const SERVICE_MODE_CODE_ORDINARY:String = "OP";// Ordinary Post
	}
}