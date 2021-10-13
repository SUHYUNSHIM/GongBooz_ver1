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

//전체 스터디 수를 받아와서, 화면에 4*4 over되면 다음 페이지로 나타나게
function studyUI(index, name,tag, max_number, cur_number){ //테이블 인덱스(0부터 시작), 스터디이름, 태그, 정원, 현재 신청인원
	var className;
	var study_status = max_number - cur_number; //신청 가능인원 
	
	//study-스터디이름- 태그- 테이블인덱스 -정원(). study 스터디윗미논술 코칭540
	className = settings.studyCss.concat(" ", name, tag, String(index), String(study_status));
	console.log(className); //어떻게 출력되는가.
	str.push('<li class="'+ className + '"'+ 
			'style="top:' +(i* settings.studyHeight).toString()+'px;left:'
							+(j * settings.studyWidth).toString()+'px">'+
							'<a title="'+name+ '">'+' '+ '</a>' +'</li>');
	$('#place').html(str.join('')); //place라는 id 태그에 내용을 쓴다. 
};
//해당 함수의 호출은 jsp에서 하도록.
//js에서 jsp의 변수들을 가져오게 한다. model. 
//https://dev-t-blog.tistory.com/8 JS에서 JSP 변수 사용하기


