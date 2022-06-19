import os

path = "/Users/akcps/personal/leetcode-solutions/leetcode-solutions/"
for file in os.listdir(path):
    if os.path.isdir(os.path.join(path, file)):
        print(file)
        for child_file in os.listdir(file):
            print(child_file)
            split_tup = os.path.splitext(child_file)
            if len(split_tup) > 1  and split_tup[1] == '.md' and split_tup[0] != 'README':
                print(split_tup)
                source_path = f"{path}{file}/{child_file}"
                destination_path = f"{path}{file}/README.md"
                os.rename(source_path, destination_path)
                print(source_path)
                print(destination_path)
        print("---------------------------------")


