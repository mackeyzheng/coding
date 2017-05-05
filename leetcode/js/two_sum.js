/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  const map = new Map();
  const ret = [];
  numbers.every((num, index) => {
    if (map.has(target - num)) {
      ret.push(map.get(target - num), index);
      return false;
    }
    map.set(num, index);
    return true;
  });
  return ret;
};
