class Processor:
    def __init__(self, model, cores, frequency_ghz):
        self.model = model
        self.cores = cores
        self.frequency_ghz = frequency_ghz

    def details(self):
        return f"{self.model}, {self.cores}-core, {self.frequency_ghz}GHz"
