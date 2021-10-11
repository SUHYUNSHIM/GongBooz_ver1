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
//전체 스터디 수를 받아와서, 화면에 4*4 over되면 다음 페이지로 나타나게
function studyUI(totalNum){
	
}
var className;
var str=[];
/*for(i=1;i<=settings.rows;i++){
	for(j=1;j<=settings.cols;j++){
		className = settings.studyCss.concat(" ",settings.)
	}
}*/