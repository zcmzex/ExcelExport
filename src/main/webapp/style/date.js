<script>
/**//** 
*������ѡ��ؼ���tiannet���ǰ�˾������ƶ�á��󲿷ִ�������meizz������ؼ��� 
*tiannet�����ʱ��ѡ���ܡ�select,object��ǩ���ع��ܣ���������С���ܡ� 
*ʹ�÷����� 
* (1)ֻѡ������ <input type="text" name="date" readOnly onClick="setDay(this);"> 
* (2)ѡ�����ں�Сʱ <input type="text" name="dateh" readOnly onClick="setDayH(this);"> 
* (3)ѡ�����ں�Сʱ������ <input type="text" name="datehm" readOnly onClick="setDayHM(this);">
 *���ò���ķ��� 
* (1)�������ڷָ��� setDateSplit(strSplit);Ĭ��Ϊ"-" 
* (2)����������ʱ��֮��ķָ��� setDateTimeSplit(strSplit);Ĭ��Ϊ" " 
* (3)����ʱ��ָ��� setTimeSplit(strSplit);Ĭ��Ϊ":" 
* (4)����(1),(2),(3)�еķָ��� setSplit(strDateSplit,strDateTimeSplit,strTimeSplit); 
* (5)���ÿ�ʼ�ͽ������ setYearPeriod(intDateBeg,intDateEnd) 
*˵���� 
* Ĭ�Ϸ��ص�����ʱ���ʽ��ͬ��2005-02-02 08:08 
*/ 
//------------------ ��ʽ���� ---------------------------// 
//���ܰ�ťͬ����ʽ 
var s_tiannet_turn_base = "height:16px;font-size:9pt;color:white;border:0 solid #CCCCCC;cursor:hand;background-color:#2650A6;";
 //���ꡢ�µȵİ�ť 
var s_tiannet_turn = "width:28px;" + s_tiannet_turn_base; 
//�رա���յȰ�ť��ʽ 
var s_tiannet_turn2 = "width:22px;" + s_tiannet_turn_base; 
//��ѡ�������� 
var s_tiannet_select = "width:64px;display:none;"; 
//�¡�ʱ����ѡ�������� 
var s_tiannet_select2 = "width:46px;display:none;"; 
//����ѡ��ؼ������ʽ 
var s_tiannet_body = "width:150;background-color:#2650A6;display:none;z-index:9998;position:absolute;" +
 "border-left:1 solid #CCCCCC;border-top:1 solid #CCCCCC;border-right:1 solid #999999;border-bottom:1 solid #999999;";
 //��ʾ�յ�td����ʽ 
var s_tiannet_day = "width:21px;height:20px;background-color:#D8F0FC;font-size:10pt;";
 //������ʽ 
var s_tiannet_font = "color:#FFCC00;font-size:9pt;cursor:hand;"; 
//���ӵ���ʽ 
var s_tiannet_link = "text-decoration:none;font-size:9pt;color:#2650A6;"; 
//���� 
var s_tiannet_line = "border-bottom:1 solid #6699CC"; 
//------------------ �������� ---------------------------// 
var tiannetYearSt = 1950;//��ѡ��Ŀ�ʼ��� 
var tiannetYearEnd = 2010;//��ѡ��Ľ������ 
var tiannetDateNow = new Date(); 
var tiannetYear = tiannetDateNow.getFullYear(); //������ı����ĳ�ʼֵ 
var tiannetMonth = tiannetDateNow.getMonth()+1; //�����µı����ĳ�ʼֵ 
var tiannetDay = tiannetDateNow.getDate(); 
var tiannetHour = 8;//tiannetDateNow.getHours(); 
var tiannetMinute = 0;//tiannetDateNow.getMinutes(); 
var tiannetArrDay=new Array(42); //����д���ڵ����� 
var tiannetDateSplit = "-"; //���ڵķָ���� 
var tiannetDateTimeSplit = " "; //������ʱ��֮��ķָ��� 
var tiannetTimeSplit = ":"; //ʱ��ķָ���� 
var tiannetOutObject; //��������ʱ��Ķ��� 
var arrTiannetHide = new Array();//��ǿ�����صı�ǩ 
var m_bolShowHour = false;//�Ƿ���ʾСʱ 
var m_bolShowMinute = false;//�Ƿ���ʾ���� 

var m_aMonHead = new Array(12); //����������ÿ���µ�������� 
m_aMonHead[0] = 31; m_aMonHead[1] = 28; m_aMonHead[2] = 31; m_aMonHead[3] = 30; m_aMonHead[4] = 31; m_aMonHead[5] = 30;
 m_aMonHead[6] = 31; m_aMonHead[7] = 31; m_aMonHead[8] = 30; m_aMonHead[9] = 31; m_aMonHead[10] = 30; m_aMonHead[11] = 31;
 // ---------------------- �û��ɵ��õĺ��� -----------------------------// 
//�û���������ֻѡ������ 
function setDay(obj){ 
tiannetOutObject = obj; 
//����ǩ����ֵ�������ڳ�ʼ��Ϊ��ǰֵ 
var strValue = tiannetTrim(tiannetOutObject.value); 
if( strValue != "" ){ 
tiannetInitDate(strValue); 
} 
tiannetPopCalendar(); 
} 
//�û���������ѡ�����ں�Сʱ 
function setDayH(obj){ 
tiannetOutObject = obj; 
m_bolShowHour = true; 
//����ǩ����ֵ�������ں�Сʱ��ʼ��Ϊ��ǰֵ 
var strValue = tiannetTrim(tiannetOutObject.value); 
if( strValue != "" ){ 
tiannetInitDate(strValue.substring(0,10)); 
var hour = strValue.substring(11,13); 
if( hour < 10 ) tiannetHour = hour.substring(1,2); 
} 
tiannetPopCalendar(); 
} 
//�û���������ѡ�����ں�Сʱ������ 
function setDayHM(obj){ 
tiannetOutObject = obj; 
m_bolShowHour = true; 
m_bolShowMinute = true; 
//����ǩ����ֵ�������ں�Сʱ�����ӳ�ʼ��Ϊ��ǰֵ 
var strValue = tiannetTrim(tiannetOutObject.value); 
if( strValue != "" ){ 
tiannetInitDate(strValue.substring(0,10)); 
var time = strValue.substring(11,16); 
var arr = time.split(tiannetTimeSplit); 
tiannetHour = arr[0]; 
tiannetMinute = arr[1]; 
if( tiannetHour < 10 ) tiannetHour = tiannetHour.substring(1,2); 
if( tiannetMinute < 10 ) tiannetMinute = tiannetMinute.substring(1,2); 
} 
tiannetPopCalendar(); 
} 
//���ÿ�ʼ���ںͽ������� 
function setYearPeriod(intDateBeg,intDateEnd){ 
tiannetYearSt = intDateBeg; 
tiannetYearEnd = intDateEnd; 
} 
//�������ڷָ���Ĭ��Ϊ"-" 
function setDateSplit(strDateSplit){ 
tiannetDateSplit = strDateSplit; 
} 
//����������ʱ��֮��ķָ���Ĭ��Ϊ" " 
function setDateTimeSplit(strDateTimeSplit){ 
tiannetDateTimeSplit = strDateTimeSplit; 
} 
//����ʱ��ָ���Ĭ��Ϊ":" 
function setTimeSplit(strTimeSplit){ 
tiannetTimeSplit = strTimeSplit; 
} 
//���÷ָ��� 
function setSplit(strDateSplit,strDateTimeSplit,strTimeSplit){ 
tiannetDateSplit(strDateSplit); 
tiannetDateTimeSplit(strDateTimeSplit); 
tiannetTimeSplit(strTimeSplit); 
} 
//����Ĭ�ϵ����ڡ���ʽΪ��YYYY-MM-DD 
function setDefaultDate(strDate){ 
tiannetYear = strDate.substring(0,4); 
tiannetMonth = strDate.substring(5,7); 
tiannetDay = strDate.substring(8,10); 
} 
//����Ĭ�ϵ�ʱ�䡣��ʽΪ��HH24:MI 
function setDefaultTime(strTime){ 
tiannetHour = strTime.substring(0,2); 
tiannetMinute = strTime.substring(3,5); 
} 
// ---------------------- end �û��ɵ��õĺ��� -----------------------------// 
//------------------ begin ҳ����ʾ���� ---------------------------// 
var weekName = new Array("��","һ","��","��","��","��","��"); 
document.write('<div id="divTiannetDate" style="'+s_tiannet_body+'" style="������ѡ��ؼ���tiannet���ǰ�˾������ƶ�ɣ�">');
 document.write('<div align="center" id="divTiannetDateText" Author="tiannet" style="padding-top:2px;">');
 document.write('<span id="tiannetYearHead" Author="tiannet" style="'+s_tiannet_font+'" '+
 'onclick="spanYearCEvent();"> ��</span>'); 
document.write('<select id="selTianYear" style="'+s_tiannet_select+'" Author="tiannet" '+
 ' onChange="tiannetYear=this.value;tiannetSetDay(tiannetYear,tiannetMonth);document.all.tiannetYearHead.style.display=\'\';'+
 'this.style.display=\'none\';">'); 
for(var i=tiannetYearSt;i <= tiannetYearEnd;i ++){ 
document.writeln('<option value="' + i + '">' + i + '��</option>'); 
} 
document.write('</select>'); 
document.write('<span id="tiannetMonthHead" Author="tiannet" style="'+s_tiannet_font+'" '+
 'onclick="spanMonthCEvent();"> ��</span>'); 
document.write('<select id="selTianMonth" style="'+s_tiannet_select2+'" Author="tiannet" '+
 'onChange="tiannetMonth=this.value;tiannetSetDay(tiannetYear,tiannetMonth);document.all.tiannetMonthHead.style.display=\'\';'+
 'this.style.display=\'none\';">'); 
for(var i=1;i <= 12;i ++){ 
document.writeln('<option value="' + i + '">' + i + '��</option>'); 
} 
document.write('</select>'); 
//document.write('</div>'); 
//document.write('<div align="center" id="divTiannetTimeText" Author="tiannet">');
 document.write('<span id="tiannetHourHead" Author="tiannet" style="'+s_tiannet_font+'display:none;" '+
 'onclick="spanHourCEvent();"> ʱ</span>'); 
document.write('<select id="selTianHour" style="'+s_tiannet_select2+'display:none;" Author="tiannet" '+
 ' onChange="tiannetHour=this.value;tiannetWriteHead();document.all.tiannetHourHead.style.display=\'\';' +
 'this.style.display=\'none\';">'); 
for(var i=0;i <= 23;i ++){ 
document.writeln('<option value="' + i + '">' + i + 'ʱ</option>'); 
} 
document.write('</select>'); 
document.write('<span id="tiannetMinuteHead" Author="tiannet" style="'+s_tiannet_font+'display:none;" '+
 'onclick="spanMinuteCEvent();"> ��</span>'); 
document.write('<select id="selTianMinute" style="'+s_tiannet_select2+'display:none;" Author="tiannet" '+
 ' onChange="tiannetMinute=this.value;tiannetWriteHead();document.all.tiannetMinuteHead.style.display=\'\';'+
 'this.style.display=\'none\';">'); 
for(var i=0;i <= 59;i ++){ 
document.writeln('<option value="' + i + '">' + i + '��</option>'); 
} 
document.write('</select>'); 
document.write('</div>'); 
//���һ������ 
document.write('<div style="'+s_tiannet_line+'"></div>'); 
document.write('<div align="center" id="divTiannetTurn" style="border:0;" Author="tiannet">');
 document.write('<input type="button" style="'+s_tiannet_turn+'" value="���" title="��һ��" onClick="tiannetPrevYear();">');
 document.write('<input type="button" style="'+s_tiannet_turn+'" value="���" title="��һ��" onClick="tiannetNextYear();"> ');
 document.write('<input type="button" style="'+s_tiannet_turn+'" value="�¡�" title="��һ��" onClick="tiannetPrevMonth();">');
 document.write('<input type="button" style="'+s_tiannet_turn+'" value="�¡�" title="��һ��" onClick="tiannetNextMonth();">');
 document.write('</div>'); 
//���һ������ 
document.write('<div style="'+s_tiannet_line+'"></div>'); 
document.write('<table border=0 cellspacing=0 cellpadding=0 bgcolor=white onselectstart="return false">');
 document.write(' <tr style="background-color:#2650A6;font-size:10pt;color:white;height:22px;" Author="tiannet">');
 for(var i =0;i < weekName.length;i ++){ 
//������� 
document.write('<td width="21" align="center" Author="tiannet">' + weekName[i] + '</td>');
 } 
document.write(' </tr>'); 
document.write('</table>'); 
//������ѡ�� 
document.write('<table border=0 cellspacing=1 cellpadding=0 bgcolor=white onselectstart="return false">');
 var n = 0; 
for (var i=0;i<5;i++) { 
document.write (' <tr align=center id="trTiannetDay' + i + '" >'); 
for (var j=0;j<7;j++){ 
document.write('<td align="center" id="tdTiannetDay' + n + '" '+ 
'onClick="tiannetDay=this.innerText;tiannetSetValue(true);" ' 
+' style="' + s_tiannet_day + '"> </td>'); 
n ++; 
} 
document.write (' </tr>'); 
} 
document.write (' <tr align=center id="trTiannetDay5" >'); 
document.write('<td align="center" id="tdTiannetDay35" onClick="tiannetDay=this.innerText;tiannetSetValue(true);" '
 +' style="' + s_tiannet_day + '"> </td>'); 
document.write('<td align="center" id="tdTiannetDay36" onClick="tiannetDay=this.innerText;tiannetSetValue(true);" '
 +' style="' + s_tiannet_day + '"> </td>'); 
document.write('<td align="right" colspan="5"><a href="javascript:tiannetClear();" style="' + s_tiannet_link + '">���</a>'+
 ' <a href="javascript:tiannetHideControl();" style="' + s_tiannet_link + '">�ر�</a>' +
 ' <a href="javascript:tiannetSetValue(true);" style="' + s_tiannet_link + '">ȷ��</a> ' +
 '</td>'); 
document.write (' </tr>'); 
document.write('</table>'); 
document.write('</div>'); 
//------------------ end ҳ����ʾ���� ---------------------------// 
//------------------ ��ʾ����ʱ���span��ǩ��Ӧ�¼� ---------------------------// 
//�������span��ǩ��Ӧ 
function spanYearCEvent(){ 
hideElementsById(new Array("selTianYear","tiannetMonthHead"),false); 
if(m_bolShowHour) hideElementsById(new Array("tiannetHourHead"),false); 
if(m_bolShowMinute) hideElementsById(new Array("tiannetMinuteHead"),false); 
hideElementsById(new Array("tiannetYearHead","selTianMonth","selTianHour","selTianMinute"),true);
 } 
//�����·�span��ǩ��Ӧ 
function spanMonthCEvent(){ 
hideElementsById(new Array("selTianMonth","tiannetYearHead"),false); 
if(m_bolShowHour) hideElementsById(new Array("tiannetHourHead"),false); 
if(m_bolShowMinute) hideElementsById(new Array("tiannetMinuteHead"),false); 
hideElementsById(new Array("tiannetMonthHead","selTianYear","selTianHour","selTianMinute"),true);
 } 
//����Сʱspan��ǩ��Ӧ 
function spanHourCEvent(){ 
hideElementsById(new Array("tiannetYearHead","tiannetMonthHead"),false); 
if(m_bolShowHour) hideElementsById(new Array("selTianHour"),false); 
if(m_bolShowMinute) hideElementsById(new Array("tiannetMinuteHead"),false); 
hideElementsById(new Array("tiannetHourHead","selTianYear","selTianMonth","selTianMinute"),true);
 } 
//��������span��ǩ��Ӧ 
function spanMinuteCEvent(){ 
hideElementsById(new Array("tiannetYearHead","tiannetMonthHead"),false); 
if(m_bolShowHour) hideElementsById(new Array("tiannetHourHead"),false); 
if(m_bolShowMinute) hideElementsById(new Array("selTianMinute"),false); 
hideElementsById(new Array("tiannetMinuteHead","selTianYear","selTianMonth","selTianHour"),true);
 } 
//��ݱ�ǩid���ػ���ʾ��ǩ 
function hideElementsById(arrId,bolHide){ 
var strDisplay = ""; 
if(bolHide) strDisplay = "none"; 
for(var i = 0;i < arrId.length;i ++){ 
var obj = document.getElementById(arrId[i]); 
obj.style.display = strDisplay; 
} 
} 
//------------------ end ��ʾ����ʱ���span��ǩ��Ӧ�¼� ---------------------------// 
//�ж�ĳ���Ƿ�Ϊ���� 
function isPinYear(year){ 
var bolRet = false; 
if (0==year%4&&((year%100!=0)||(year%400==0))) { 
bolRet = true; 
} 
return bolRet; 
} 
//�õ�һ���µ���������Ϊ29�� 
function getMonthCount(year,month){ 
var c=m_aMonHead[month-1]; 
if((month==2)&&isPinYear(year)) c++; 
return c; 
} 
//�������õ�ǰ���ա���Ҫ�Ƿ�ֹ�ڷ��ꡢ����ʱ����ǰ�մ��ڵ��µ������ 
function setRealDayCount() { 
if( tiannetDay > getMonthCount(tiannetYear,tiannetMonth) ) { 
//���ǰ���մ��ڵ��µ�����գ���ȡ��������� 
tiannetDay = getMonthCount(tiannetYear,tiannetMonth); 
} 
} 
//�ڸ�λ��ǰ���� 
function addZero(value){ 
if(value < 10 ){ 
value = "0" + value; 
} 
return value; 
} 
//ȡ���ո� 
function tiannetTrim(str) { 
return str.replace(/(^\s*)|(\s*$)/g,""); 
} 
//Ϊselect����һ��option 
function createOption(objSelect,value,text){ 
var option = document.createElement("OPTION"); 
option.value = value; 
option.text = text; 
objSelect.options.add(option); 
} 
//��ǰ�� Year 
function tiannetPrevYear() { 
if(tiannetYear > 999 && tiannetYear <10000){tiannetYear--;} 
else{alert("��ݳ�����Χ��1000-9999����");} 
tiannetSetDay(tiannetYear,tiannetMonth); 
//������С���������С��ݣ��򴴽���Ӧ��option 
if( tiannetYear < tiannetYearSt ) { 
tiannetYearSt = tiannetYear; 
createOption(document.all.selTianYear,tiannetYear,tiannetYear + "��"); 
} 
checkSelect(document.all.selTianYear,tiannetYear); 
tiannetWriteHead(); 
} 
//��� Year 
function tiannetNextYear() { 
if(tiannetYear > 999 && tiannetYear <10000){tiannetYear++;} 
else{alert("��ݳ�����Χ��1000-9999����");return;} 
tiannetSetDay(tiannetYear,tiannetMonth); 
//�����ݳ�������������ݣ��򴴽���Ӧ��option 
if( tiannetYear > tiannetYearEnd ) { 
tiannetYearEnd = tiannetYear; 
createOption(document.all.selTianYear,tiannetYear,tiannetYear + "��"); 
} 
checkSelect(document.all.selTianYear,tiannetYear); 
tiannetWriteHead(); 
} 
//ѡ����� 
function tiannetToday() { 
tiannetYear = tiannetDateNow.getFullYear(); 
tiannetMonth = tiannetDateNow.getMonth()+1; 
tiannetDay = tiannetDateNow.getDate(); 
tiannetSetValue(true); 
//tiannetSetDay(tiannetYear,tiannetMonth); 
//selectObject(); 
} 
//��ǰ���·� 
function tiannetPrevMonth() { 
if(tiannetMonth>1){tiannetMonth--}else{tiannetYear--;tiannetMonth=12;} 
tiannetSetDay(tiannetYear,tiannetMonth); 
checkSelect(document.all.selTianMonth,tiannetMonth); 
tiannetWriteHead(); 
} 
//����·� 
function tiannetNextMonth() { 
if(tiannetMonth==12){tiannetYear++;tiannetMonth=1}else{tiannetMonth++} 
tiannetSetDay(tiannetYear,tiannetMonth); 
checkSelect(document.all.selTianMonth,tiannetMonth); 
tiannetWriteHead(); 
} 
//��span��ǩ��д���ꡢ�¡�ʱ���ֵ���� 
function tiannetWriteHead(){ 
document.all.tiannetYearHead.innerText = tiannetYear + "��"; 
document.all.tiannetMonthHead.innerText = tiannetMonth + "��"; 
if( m_bolShowHour ) document.all.tiannetHourHead.innerText = " "+tiannetHour + "ʱ";
 if( m_bolShowMinute ) document.all.tiannetMinuteHead.innerText = tiannetMinute + "��";
 tiannetSetValue(false);//���ı���ֵ���������ر��ؼ� 
} 
//������ʾ�� 
function tiannetSetDay(yy,mm) { 

setRealDayCount();//���õ�����ʵ���� 
tiannetWriteHead(); 
var strDateFont1 = "", strDateFont2 = "" //����������ʾ�ķ�� 
for (var i = 0; i < 37; i++){tiannetArrDay[i]=""}; //����ʾ�������ȫ����� 
var day1 = 1; 
var firstday = new Date(yy,mm-1,1).getDay(); //ĳ�µ�һ������ڼ� 
for (var i = firstday; day1 < getMonthCount(yy,mm)+1; i++){ 
tiannetArrDay[i]=day1;day1++; 
} 
//���������ʾ�յ����һ�еĵ�һ����Ԫ���ֵΪ�գ����������С� 
//if(tiannetArrDay[35] == ""){ 
// document.all.trTiannetDay5.style.display = "none"; 
//} else { 
// document.all.trTiannetDay5.style.display = ""; 
//} 
for (var i = 0; i < 37; i++){ 
var da = eval("document.all.tdTiannetDay"+i) //��д�µ�һ���µ������������� 
if (tiannetArrDay[i]!="") { 
//�ж��Ƿ�Ϊ��ĩ���������ĩ�����Ϊ��ɫ���� 
if(i % 7 == 0 || (i+1) % 7 == 0){ 
strDateFont1 = "<font color=#f0000>" 
strDateFont2 = "</font>" 
} else { 
strDateFont1 = ""; 
strDateFont2 = "" 
} 
da.innerHTML = strDateFont1 + tiannetArrDay[i] + strDateFont2; 
//����ǵ�ǰѡ����죬��ı���ɫ 
if(tiannetArrDay[i] == tiannetDay ) { 
da.style.backgroundColor = "#CCCCCC"; 
} else { 
da.style.backgroundColor = "#EFEFEF"; 
} 
da.style.cursor="hand" 
} else { 
da.innerHTML="";da.style.backgroundColor="";da.style.cursor="default" 
} 
}//end for 
tiannetSetValue(false);//���ı���ֵ���������ر��ؼ� 
}//end function tiannetSetDay 
//���option��ֵѡ��option 
function checkSelect(objSelect,selectValue) { 
var count = parseInt(objSelect.length); 
if( selectValue < 10 && selectValue.toString().length == 2) { 
selectValue = selectValue.substring(1,2); 
} 
for(var i = 0;i < count;i ++){ 
if(objSelect.options[i].value == selectValue){ 
objSelect.selectedIndex = i; 
break; 
} 
}//for 
} 
//ѡ���ꡢ�¡�ʱ���ֵ������� 
function selectObject(){ 
//������С���������С��ݣ��򴴽���Ӧ��option 
if( tiannetYear < tiannetYearSt ) { 
for( var i = tiannetYear;i < tiannetYearSt;i ++ ){ 
createOption(document.all.selTianYear,i,i + "��"); 
} 
tiannetYearSt = tiannetYear; 
} 
//�����ݳ�������������ݣ��򴴽���Ӧ��option 
if( tiannetYear > tiannetYearEnd ) { 
for( var i = tiannetYearEnd+1;i <= tiannetYear;i ++ ){ 
createOption(document.all.selTianYear,i,i + "��"); 
} 
tiannetYearEnd = tiannetYear; 
} 
checkSelect(document.all.selTianYear,tiannetYear); 
checkSelect(document.all.selTianMonth,tiannetMonth); 
if( m_bolShowHour ) checkSelect(document.all.selTianHour,tiannetHour); 
if( m_bolShowMinute ) checkSelect(document.all.selTianMinute,tiannetMinute); 
} 
//���������ʱ��Ŀؼ���ֵ 
//����bolHideControl - �Ƿ����ؿؼ� 
function tiannetSetValue(bolHideControl){ 
var value = ""; 
if( !tiannetDay || tiannetDay == "" ){ 
tiannetOutObject.value = value; 
return; 
} 
var mm = tiannetMonth; 
var day = tiannetDay; 
if( mm < 10 && mm.toString().length == 1) mm = "0" + mm; 
if( day < 10 && day.toString().length == 1) day = "0" + day; 
value = tiannetYear + tiannetDateSplit + mm + tiannetDateSplit + day; 
if( m_bolShowHour ){ 
var hour = tiannetHour; 
if( hour < 10 && hour.toString().length == 1 ) hour = "0" + hour; 
value += tiannetDateTimeSplit + hour; 
} 
if( m_bolShowMinute ){ 
var minute = tiannetMinute; 
if( minute < 10 && minute.toString().length == 1 ) minute = "0" + minute; 
value += tiannetTimeSplit + minute; 
} 
tiannetOutObject.value = value; 
//document.all.divTiannetDate.style.display = "none"; 
if( bolHideControl ) { 
tiannetHideControl(); 
} 
} 
//�Ƿ���ʾʱ�� 
function showTime(){ 
if( !m_bolShowHour && m_bolShowMinute){ 
alert("���Ҫѡ����ӣ���������ѡ��Сʱ��"); 
return; 
} 
hideElementsById(new Array("tiannetHourHead","selTianHour","tiannetMinuteHead","selTianMinute"),true);
 if( m_bolShowHour ){ 
//��ʾСʱ 
hideElementsById(new Array("tiannetHourHead"),false); 
} 
if( m_bolShowMinute ){ 
//��ʾ���� 
hideElementsById(new Array("tiannetMinuteHead"),false); 
} 
} 
//������ʾ����ѡ��ؼ��������û�ѡ�� 
function tiannetPopCalendar(){ 
//������������ʾ���Ӧ��head 
hideElementsById(new Array("selTianYear","selTianMonth","selTianHour","selTianMinute"),true);
 hideElementsById(new Array("tiannetYearHead","tiannetMonthHead","tiannetHourHead","tiannetMinuteHead"),false);
 tiannetSetDay(tiannetYear,tiannetMonth); 
tiannetWriteHead(); 
showTime(); 
var dads = document.all.divTiannetDate.style; 
var iX, iY; 

var h = document.all.divTiannetDate.offsetHeight; 
var w = document.all.divTiannetDate.offsetWidth; 
//����left 
if (window.event.x + h > document.body.offsetWidth - 10 ) 
iX = window.event.x - h - 5 ; 
else 
iX = window.event.x + 5; 
if (iX <0) 
iX=0; 
//����top 
iY = window.event.y; 
if (window.event.y + w > document.body.offsetHeight - 10 ) 
iY = document.body.scrollTop + document.body.offsetHeight - w - 5 ; 
else 
iY = document.body.scrollTop +window.event.y + 5; 
if (iY <0) 
iY=0; 
dads.left = iX; 
dads.top = iY; 
tiannetShowControl(); 
selectObject(); 
} 
//��������ؼ�(ͬʱ��ʾ��ǿ�����صı�ǩ) 
function tiannetHideControl(){ 
document.all.divTiannetDate.style.display = "none"; 
tiannetShowObject(); 
arrTiannetHide = new Array();//�������صı�ǩ������� 
} 
//��ʾ����ؼ�(ͬʱ���ػ��ڵ��ı�ǩ) 
function tiannetShowControl(){ 
document.all.divTiannetDate.style.display = ""; 
tiannetHideObject("SELECT"); 
tiannetHideObject("OBJECT"); 
} 
//��ݱ�ǩ������ر�ǩ�������ס�ؼ���select��object 
function tiannetHideObject(strTagName) { 

x = document.all.divTiannetDate.offsetLeft; 
y = document.all.divTiannetDate.offsetTop; 
h = document.all.divTiannetDate.offsetHeight; 
w = document.all.divTiannetDate.offsetWidth; 

for (var i = 0; i < document.all.tags(strTagName).length; i++) 
{ 

var obj = document.all.tags(strTagName)[i]; 
if (! obj || ! obj.offsetParent) 
continue; 
// ��ȡԪ�ض���BODY��ǵ������� 
var objLeft = obj.offsetLeft; 
var objTop = obj.offsetTop; 
var objHeight = obj.offsetHeight; 
var objWidth = obj.offsetWidth; 
var objParent = obj.offsetParent; 

while (objParent.tagName.toUpperCase() != "BODY"){ 
objLeft += objParent.offsetLeft; 
objTop += objParent.offsetTop; 
objParent = objParent.offsetParent; 
} 
//alert("�ؼ����:" + x + "select���" + (objLeft + objWidth) + "�ؼ��ײ�:" + (y+h) + "select��:" + objTop);
 
var bolHide = true; 
if( obj.style.display == "none" || obj.style.visibility == "hidden" || obj.getAttribute("Author") == "tiannet" ){
 //����ǩ����������صģ�����Ҫ�����ء�����ǿؼ��е�������Ҳ�������ء� 
bolHide = false; 
} 
if( ( (objLeft + objWidth) > x && (y + h + 20) > objTop && (objTop+objHeight) > y && objLeft < (x+w) ) && bolHide ){
 //arrTiannetHide.push(obj);//��¼�����صı�ǩ���� 
arrTiannetHide[arrTiannetHide.length] = obj; 
obj.style.visibility = "hidden"; 
} 


} 
} 
//��ʾ�����صı�ǩ 
function tiannetShowObject(){ 
for(var i = 0;i < arrTiannetHide.length;i ++){ 
//alert(arrTiannetHide[i]); 
arrTiannetHide[i].style.visibility = ""; 
} 
} 
//��ʼ�����ڡ� 
function tiannetInitDate(strDate){ 
var arr = strDate.split(tiannetDateSplit); 
tiannetYear = arr[0]; 
tiannetMonth = arr[1]; 
tiannetDay = arr[2]; 
} 
//清空 
function tiannetClear(){ 
tiannetOutObject.value = ""; 
tiannetHideControl(); 
} 
//任意点击时关闭该控件 
function document.onclick(){ 
with(window.event.srcElement){ 
if (tagName != "INPUT" && getAttribute("Author") != "tiannet") 
tiannetHideControl(); 
} 
} 
//按ESC键关闭该控件 
function document.onkeypress(){ 
if( event.keyCode == 27 ){ 
tiannetHideControl(); 
} 
} 
</script> 