/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */

// solution1
var twoSum = function(numbers, target) {
  let i = 0;
  let j = numbers.length - 1;
  const ret = [];
  while (i < j) {
    const sum = numbers[i] + numbers[j];
    if (sum < target) {
      i++;
    } else if (sum > target) {
      j--;
    } else {
      ret.push(i+1, j+1);
      break;
    }
  }
  return ret;
};

// solution2
var twoSum = function(numbers, target) {
  const map = new Map();
  const ret = [];
  numbers.every((num, index) => {
    if (map.has(target - num)) {
      ret.push(map.get(target - num) + 1, index + 1);
      return false;
    }
    map.set(num, index);
    return true;
  });
  return ret;
};
