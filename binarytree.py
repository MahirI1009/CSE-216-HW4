class BinaryTree:

    # 5. constructor to initialize binary tree as an empty tree or with a single value
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

    # 6. add_leftchild and add_rightchild methods
    # 7. TypeError if new child is not of the same type as the rest of the elements of the tree
    def add_leftchild(self, left):
        if isinstance(left.data, type(self.data)) or left.data is None:
            self.left = left
        else:
            raise TypeError("Type mismatch between " + str(type(self.data)) + " and " + str(type(left)))

    def add_rightchild(self, right):
        if isinstance(right.data, type(self.data)) or right.data is None:
            self.right = right
        else:
            raise TypeError("Type mismatch between " + str(type(self.data)) + " and " + str(type(right)))

    # 8. property and setter
    @property
    def data(self):
        return self.__data

    @data.setter
    def data(self, data):
        self.__data = data

    # 9. implementation of iter()
    def __iter__(self):
        if self.data is not None or self.data is None and isinstance(self, BinaryTree):
            yield self.data
        if self.left is not None:
            for d in self.left:
                yield d
        if self.right is not None:
            for d in self.right:
                yield d
