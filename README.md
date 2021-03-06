# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 사다리 생성 Todo List
- `참여자(Player)`
    - [x] `참여자(Player)` 이름을 입력받는다.
        - [x] 이름에 null, 공백이 들어올 경우 예외를 발생한다.
        - [x] `참여자(Player)` 이름은 최대 5글자이다.
        - [x] 5글자가 넘을경우 예외를 발생한다.
    - [x] `참여자(Player)` 이름은 쉼표를 기준으로 구분한다.
        
- `높이(Height)` 
    - [x] `높이(Height)`를 입력받는다.
        - [x] `높이(Height)`가 0 이하면 예외를 발생한다.

- `사다리(Ladder)`
    - [x] 높이당 하나의 `라인(Line)`을 생성할 수 있다.
        
- `라인(Line)`
    - [x] `참여자(Player)`가 한명일 경우 라인은 생성되지 않는다.
    - [x] `참여자(Player)`가 두명이상 일경우 연속된 라인을 생성할 수 있다.
        - [x] |-----|-----| 모양과 같이 가로 `라인(Line)`이 겹치면 안된다.

- `출력(OutputView)`
    - [x] `참여자(Player)` 이름을 5자 기준으로 출력한다.
    - [x] `사다리(Ladder)` 를 출력한다.
        
---

## 3단계 사다리 게임 실행 Todo List
- `뽑기 결과(Prize)`
    - [x] `뽑기 결과(Prize)`를 입력받는다.
        - [x] `뽑기 결과(Prize)`는 쉼표로 구분한다.
        - [x] `뽑기 결과(Prize)`의 갯수는 `참여자(Player)`의 수와 동일해야 한다.
    - [x] `뽑기 결과(Prize)`는 위치를 갖고있다.     

- `참여자(Player)`
    - [x] `참여자(Player)`는 시작 위치를 가지고 있다.
    - [x] `참여자(Player)`는 이동할 수 있다.
    - [x] `참여자(Player)`는 자신의 시작 위치를 갖고 있다.

- `위치(Position)`
    - [x] 왼쪽으로 이동할 수 있다.
        - [x] 왼쪽으로 이동할 경우 현재 위치 -1
    - [x] 오른쪽으로 이동할 수 있다.
        - [x] 오른쪽으로 이동할 경우 현재 위치 + 1

- `결과(Result)`
    - [x] 참여자 이름으로 결과를 구할 수 있다.