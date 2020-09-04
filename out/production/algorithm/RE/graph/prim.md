# Prim 알고리즘

## 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어가는 방식

1. 임의 정점을 하나 선택해서 시작
2. 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택
3. 모든 정점이 선택될 때까지 1,2 과정을 반복한다.

## 서로소인 2개의 집합 정보를 유지한다.

- 트리 정점들 - MST를 만들기 위해서 선택된 정점들
- 비트리 정점들 - 선택되지 않은 정점들

## 최단 경로

- 최단 경로 정의
	- 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에서 간선의 가중치의 합이 최소인 경로

- 하나의 시작 정점에서 끝 정점까지의 최단 경로
	- 다익스트라 알고리즘
		- 시작 정점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
		- 탐욕 기법을 이용한 알고리즘으로, 프림 알고리즘과 유사하다.
	- 벨만-포드 알고리즘

- 모든 정점들에 대한 최단 경로
	- 플로이드 - 와샬 알고리즘
