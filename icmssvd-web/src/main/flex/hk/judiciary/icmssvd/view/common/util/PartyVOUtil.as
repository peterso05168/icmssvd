package hk.judiciary.icmssvd.view.common.util
{
	import hk.judiciary.icmssvd.view.svdReq.vo.PartyVO;

	public class PartyVOUtil
	{
		public static function getRequestName(partyVo:PartyVO):String{
			var requestName:String = new String;
			if(partyVo != null){
				var typeCd:String;
				var serNo:String;
				
				if(partyVo.participantRoleType != null){
					typeCd = partyVo.participantRoleType.participantRoleTypeCode;
				}
				
				if(partyVo.respondentSeqNo != 0){
					serNo = partyVo.respondentSeqNo+"";
				}
				
				typeCd = getStr(typeCd);
				serNo = getStr(serNo);
				
				if(typeCd != "" || serNo != ""){
					requestName += "(" + typeCd + serNo + ") ";
				}
				requestName += getStr(partyVo.englishSurname) + 
					" " + 
					getStr(partyVo.englishGivenName);
			}
			return requestName;
		}
		
		public static function getRequestNameWithChi(partyVo:PartyVO):String{
			var requestName:String = new String;
			if(partyVo != null){
				var typeCd:String;
				var serNo:String;
				
				if(partyVo.participantRoleType != null){
					typeCd = partyVo.participantRoleType.participantRoleTypeCode;
				}
				
				if(partyVo.respondentSeqNo != 0){
					serNo = partyVo.respondentSeqNo+"";
				}
				
				typeCd = getStr(typeCd);
				serNo = getStr(serNo);
				
				if(typeCd != "" || serNo != ""){
					requestName += "(" + typeCd + serNo + ") ";
				}
				requestName += getStr(partyVo.englishSurname) + " " + getStr(partyVo.englishGivenName);
				requestName += " " + getStr(partyVo.chineseSurname) + " " + getStr(partyVo.chineseGivenName);
			}
			return requestName;
		}
		
		public static function getStr(str:String):String{
			if(str == null){
				str = "";
			}
			return str;
		}
	}
}