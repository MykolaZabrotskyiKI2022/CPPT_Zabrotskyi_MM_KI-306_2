class Memory:
    def __init__(self, size_gb, type_memory):
        self.size_gb = size_gb
        self.type_memory = type_memory

    def details(self):
        return f"{self.size_gb}GB {self.type_memory}"
