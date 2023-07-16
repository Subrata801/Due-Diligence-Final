import { HttpHeaders } from "@angular/common/http";

export class Constants{
    public static httpOptions_app_json = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
      };

      public static  customIntegerValueOptions: any[] = [
        { value: 1, viewValue: 'One' },
        { value: 2, viewValue: 'Two' },
        { value: 3, viewValue: 'Three' }
      ];
    
      public static customOptions: any[] = [
        { value: 'option-1', viewValue: 'One' },
        { value: 'option-2', viewValue: 'Two' },
        { value: 'option-3', viewValue: 'Three' }
      ];

      public static clientTypeBank = 2;

      public static clientTypeAuditFirm = 3

}