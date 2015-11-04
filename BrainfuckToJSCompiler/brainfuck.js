function callMessage() {
    var memory = Array.apply(null, new Array(30000)).map(function () {
        return 0;
    });
    var pointer = 0;
    var result = '';
    memory[pointer] += 8;
    while (memory[pointer] != 0) {
        pointer += 1;
        memory[pointer] += 4;
        while (memory[pointer] != 0) {
            pointer += 1;
            memory[pointer] += 2;
            pointer += 1;
            memory[pointer] += 3;
            pointer += 1;
            memory[pointer] += 3;
            pointer += 1;
            memory[pointer] += 1;
            pointer -= 4;
            memory[pointer] -= 1;
        }
        pointer += 1;
        memory[pointer] += 1;
        pointer += 1;
        memory[pointer] += 1;
        pointer += 1;
        memory[pointer] -= 1;
        pointer += 2;
        memory[pointer] += 1;
        while (memory[pointer] != 0) {
            pointer -= 1;
        }
        pointer -= 1;
        memory[pointer] -= 1;
    }
    pointer += 2;
    result += String.fromCharCode(memory[pointer]);
    pointer += 1;
    memory[pointer] -= 3;
    result += String.fromCharCode(memory[pointer]);
    memory[pointer] += 7;
    result += String.fromCharCode(memory[pointer]);
    result += String.fromCharCode(memory[pointer]);
    memory[pointer] += 3;
    result += String.fromCharCode(memory[pointer]);
    pointer += 2;
    result += String.fromCharCode(memory[pointer]);
    pointer -= 1;
    memory[pointer] -= 1;
    result += String.fromCharCode(memory[pointer]);
    pointer -= 1;
    result += String.fromCharCode(memory[pointer]);
    memory[pointer] += 3;
    result += String.fromCharCode(memory[pointer]);
    memory[pointer] -= 6;
    result += String.fromCharCode(memory[pointer]);
    memory[pointer] -= 8;
    result += String.fromCharCode(memory[pointer]);
    pointer += 2;
    memory[pointer] += 1;
    result += String.fromCharCode(memory[pointer]);
    pointer += 1;
    memory[pointer] += 2;
    result += String.fromCharCode(memory[pointer]);

    return alert(result);
}
callMessage();