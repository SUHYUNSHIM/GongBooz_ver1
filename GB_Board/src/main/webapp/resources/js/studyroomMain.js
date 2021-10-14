var settings={
			
		rows:4, //임의로 사이즈 조절. 페이지 넘어가는 경우도 나중에 생각해야 한다.
		cols:4,
		
		//태그별로 css 적응
		tagCssPrefix1: '외국어',
		tagCssPrefix2:'면접',
		tagCssPrefix3:'스터디윗미',
		tagCssPrefix4:'대외활동',
		taggCssPrefix5:'자격증',
		tagCssPrefix6:'공무원',
		tagCssPrefix7:'기타',
		
		//정원이 1명 남은 스터디
		//완석인 스터디
		//default는 흰색 
		memberCssPrefix1: '마감 임박',
		memberCssPrefix2: '마감',
		memberCssPrefix3: '여유',
		
		//선택하면 눌림효과가 나타나도록
		selectedCss: 'selected',
		
		//한 스터디 버튼당 크기
		studyWidth: 150,
		studyHeight: 200,
		
		//
		studyCss: 'study'
};

var str=[];
var className;

//전체 스터디 수를 받아와서, 화면에 4*4 over되면 다음 페이지로 나타나게
function studyUI(index, name,tag, max_number, cur_number){ //테이블 인덱스(0부터 시작), 스터디이름, 태그, 정원, 현재 신청인원
	
	var study_status = max_number - cur_number; //신청 가능인원 
	className = settings.studyCss;
	
	switch(tag){
	case settings.tagCssPrefix1:
		className += ' '+settings.tagCssPrefix1;		
		break;
	case  settings.tagCssPrefix2:
		className += ' '+settings.tagCssPrefix2;
		break;
	case  settings.tagCssPrefix3:
		className += ' '+settings.tagCssPrefix3;
		break;
	case  settings.tagCssPrefix4:
		className += ' '+settings.tagCssPrefix4;
		break;
	case  settings.tagCssPrefix5:
		className += ' '+settings.tagCssPrefix5;
		break;
	case  settings.tagCssPrefix6:
		className += ' '+settings.tagCssPrefix6;
		break;
	case  settings.tagCssPrefix7:
		className += ' '+settings.tagCssPrefix7;
		break;
	}
	console.log("prefix가 추가되었는가"+className); //어떻게 출력되는가.
	//String(study_status)
	//study-스터디이름- 태그- 테이블인덱스 -정원(). study 스터디윗미논술 코칭540
	//className = settings.studyCss.concat(" ", name, tag, String(study_status),index);
	
	str.push('<li class="'+ className + '"'+ 'style="width:250px; height:200px; top:' +(index * settings.studyHeight).toString()+'px;left:'
							+(index * settings.studyWidth).toString()+'px">'+
							'<div id= "'+tag+'"'+'style="width:100px;height:20px;">'+ //태그명
							'<div id= "'+name+'"'+'style="margin-top:39px;width:200px;height:20px;">'+name+'</div>'+ //이름
							'<div id= "'+study_status+'"'+'style="margin-top:90px;width:200px;height:15px;">참여인원'+" "+cur_number+
							" / "+max_number+'</div>'+							
							'<a title="'+name+ '">'+' '+ '</a>'+className +'</li>');
	
	console.log(className);
	$('#rooms').html(str.join('')); //place라는 id 태그에 내용을 쓴다. 
};
//해당 함수의 호출은 jsp에서 하도록.
//js에서 jsp의 변수들을 가져오게 한다. model. 
//https://dev-t-blog.tistory.com/8 JS에서 JSP 변수 사용하기
/*console.log("${alist}");*/

studyUI(1, '중간고사 스터디윗미','스터디윗미',30,0); //study 중간고사 스터디윗미스터디윗미130

