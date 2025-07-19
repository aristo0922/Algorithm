package main

import (
	"fmt"
	"bufio"
	"os"
)

const ratio int = 60
const mToS_5 int = 5 * ratio
const mTos int = 1 * ratio
const sec int = 10
var arr = []int {mToS_5, mTos, sec}

func greedy(goal int) (int, int, int) {

	result := []int {0,0,0}
	res := goal

	for index := 0 ; index < 3; index++ {
		result[index], res =  calc(res, arr[index])
	}

	if res == 0 {
		return result[0], result[1], result[2]
	}
	
	return -1, 0, 0
}

func calc(target int, devide int) (int, int) {
	return target/devide, target%devide
}

func main(){

	var reader = bufio.NewReader(os.Stdin)
	var writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var cookTime int

	fmt.Fscan(reader, &cookTime)
	result := make([]int, 3)
	
	result[0], result[1], result[2]  = greedy(cookTime)

	if result[0] == -1 {
		fmt.Fprintln(writer, -1)
	} else {
		fmt.Fprintf(writer, "%d %d %d\n", result[0], result[1], result[2])
	}
}

