var blank = 16; // 빈 정사각형의 현 위치
var count = 0; // 현재 게임에서 정사각형 총 이동 횟수
var start; // 게임 시작 전이면 0, 아니면 1(초기화 함수에서 섞는 도중에 성공 메시지가 출력되는 것을 방지하기 위한 boolean 변수)

// min 이상 max 이하인 정수 난수 생성 함수
function getRandomInt(min, max)
{
    min = Math.ceil(min); // Math.ceil(): 인자보다 크거나 같은 최소 정수 반환
    max = Math.floor(max); // Math.floor(): 인자보다 작거나 같은 최대 정수 반환
    return Math.floor(Math.random() * (max - min + 1)) + min; // Math.random(): 0 이상 1 미만의 구간에서 근사적으로 균일한(approximately uniform) 부동소숫점 의사난수를 반환. 암호학적으로 안전한 난수를 제공하지는 않음
}

// 초기화 함수 선언 및 실행
function initialize()
{
    start = 0;
    var near = [-4, -1, 1, 4];

    for (var i = 0; i < 1000; i++)
    {
        do {
            var a = getRandomInt(0, 3);
        } while (blank - 1 + near[a] < 0 || 15 < blank - 1 + near[a]);
        swap('n' + String(blank - 1 + near[a]));
        if (i == 999 && checkClear()) // 최종적으로 퍼즐이 모두 맞은 상태에서 초기화되면 다시 초기화
            i = 0;
    }

    start = 1;
    count = 0;
    move();
}

// 퍼즐을 모두 맞추었으면 1, 그렇지 않으면 0을 리턴하는 함수
function checkClear()
{
    for (var i = 0; i < 15; i++)
    {
        if (document.querySelector('.n' + i).innerHTML != i + 1)
        return 0;
    }
    return 1;
}

// 모두 맞추기까지 걸린 총 이동 횟수를 알려주고 슬라이딩 퍼즐을 초기화해주는 함수
function Success()
{
    alert(count + "회 만에 성공했습니다!");
    initialize();
}

// 이동 횟수를 보여주는 함수
function move()
{
    document.querySelector('.count').innerHTML = 'Move: ' + String(count);
}

// 움직일 수 있는 정사각형을 클릭했을 때 빈 정사각형과 클릭한 정사각형을 교환해주는 함수
function swap(s)
{
    var arr = s.split('n');
    var num = Number(arr[1]) + 1;
    
    // 움직일 수 있는 정사각형(빈 정사각형과 맞닿은 정사각형)이 아니면 함수 종료
    if ((num != blank - 4 && num != blank - 1 && num != blank + 1 && num != blank + 4) || (num % 4 == 0 && blank == num + 1) || (num % 4 == 1 && blank == num - 1))
        return;
    else
    {
        var temp;

        // 빈 정사각형과 클릭한 정사각형을 교환(innerHTML, backgroundColor)
        temp = document.querySelector('.' + s).innerHTML;
        document.querySelector('.' + s).innerHTML = document.querySelector('.n' + String(blank - 1)).innerHTML;
        document.querySelector('.n' + String(blank - 1)).innerHTML = temp;
        /*
        ** querySelector()로 Element에서 Style 속성값을 가져오려면 HTML 내 해당 Element에 속성 값이 적혀있어야 합니다.
        ** (별도의 CSS 파일, style 태그 사용했으면 빈 값이 들어있음)
        ** document.defaultView.getComputedStyle(Element).getPropertyValue("속성명"))을 통해 가져올 수도 있지만 읽기 전용이라서 수정이 불가능합니다.
        */
        temp = document.querySelector('.' + s).style.backgroundColor;
        document.querySelector('.' + s).style.backgroundColor = document.querySelector('.n' + String(blank - 1)).style.backgroundColor;
        document.querySelector('.n' + String(blank - 1)).style.backgroundColor = temp;

        blank = num;
        count++;
        if (start && checkClear())
            Success();
        move();
    }
}

initialize();
// 정사각형을 클릭했을 때 swap() 함수를 실행합니다.
for (var i = 0; i < 16; i++)
{
    document.querySelector('.n' + i).onclick = function()
    {
        swap(this.className);
    };
}