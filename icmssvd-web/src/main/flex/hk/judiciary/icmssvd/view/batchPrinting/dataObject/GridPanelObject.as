package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	import mx.collections.ArrayCollection;
	
	import hk.judiciary.fmk.view.component.AdvancedDataGrid;
	import hk.judiciary.icmssvd.view.batchPrinting.enumObject.MessageInfoType;

	public class GridPanelObject extends FieldObject
	{
		public function GridPanelObject()
		{
			super();
		}
		
		override public function validate(silenceValidate:Boolean = false):Boolean
		{
			// TODO Auto Generated method stub
			//return super.validate();
			var isValid:Boolean = true;
			if (!silenceValidate) {
				clearInvalid();
			}
			
			if (isValid) {
				isValid = requiredValidation(null);
			}
			
			if (!silenceValidate) {
				showErrorTooltip(getErrorTooltip());
			}
			return isValid;
		}
		
		override protected function requiredValidation(value:Object):Boolean
		{
			// TODO Auto Generated method stub
			//return super.requiredValidation();
			
			var isValid:Boolean = true;
			
			var gridPanel:AdvancedDataGrid = this.viewObject as AdvancedDataGrid;
			//CommonUtils.showDebugInfo("rowCount "+ ArrayCollection(gridPanel.dataProvider).length);
			
			if (this.required && ArrayCollection(gridPanel.dataProvider).length == 0) {
				isValid = false;
				this.messageInfoVO = MessageInfoType.FIELD_IS_REQUIRED; 
			}
			
			return isValid;
		}
		
		
	}
}