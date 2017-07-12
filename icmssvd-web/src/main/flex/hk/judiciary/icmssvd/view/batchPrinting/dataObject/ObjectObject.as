package hk.judiciary.icmssvd.view.batchPrinting.dataObject
{
	public class ObjectObject extends FieldObject
	{
		public function ObjectObject()
		{
			super();
			value = null;
		}
		
		[Bindable]
		public function get value():Object {
			return super.getValue();
		}
		public function set value(value:Object):void {
			return super.setValue(value);
		}
	}
}